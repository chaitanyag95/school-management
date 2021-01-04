package com.chaitanya.schoolmanagement.batch;

import com.chaitanya.schoolmanagement.model.student.Student;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class Reader {
    public static FlatFileItemReader<Student> reader(String path) {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<Student>();

        reader.setResource(new ClassPathResource(path));
        reader.setLineMapper(new DefaultLineMapper<Student>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"fullName", "email", "phoneNumber", "password", "course"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {
                    {
                        setTargetType(Student.class);
                    }
                });
            }
        });
        return reader;
    }
}
