package com.lucas.enums.converters;

import com.lucas.enums.Category;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class CategoryConverters implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null){
            return null;
        }
        return category.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String s) {
        if (s == null){
            return null;
        }
        return Stream.of(Category.values())
                .filter(c -> c.getValue().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
