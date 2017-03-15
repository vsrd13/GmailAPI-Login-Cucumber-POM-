package Transformation;

import cucumber.api.Transformer;

/**
 * Created by Kumar on 2/10/2017.
 */
public class EmailTransform extends Transformer<String> {

    @Override
    public String transform(String userName) {
        return userName.concat("@ea.com");
    }
}
