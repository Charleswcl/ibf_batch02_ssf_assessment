package batch02_ssf_assessment.ssf.assessment.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import batch02_ssf_assessment.ssf.assessment.Model.Item;

@Service
public class ItemService {

    public static final String[] ITEM_NAMES = {
            "apple", "orange", "bread", "cheese", "chicken", "mineral_water", "instant_noodles"
    };

    private final Set<String> itemNames;

    public ItemService() {
        itemNames = new HashSet<>(Arrays.asList(ITEM_NAMES));
    }

    public List<ObjectError> validateItem(Item name) {
        List<ObjectError> errors = new LinkedList<>();
        FieldError error;

        if (!itemNames.contains(name.getName().toLowerCase())) {
            error = new FieldError("item", "name", "We do not stock %s ".formatted(name.getName()));
            errors.add(error);
        }

        return errors;
    }
}
