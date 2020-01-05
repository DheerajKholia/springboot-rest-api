package com.dheeraj.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    //value1,value2
    public MappingJacksonValue retrieveBean(){
        SomeBean bean= new SomeBean("value1","value2","value3");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
                .filterOutAllExcept("value1","value2");

        FilterProvider filters=new SimpleFilterProvider()
                .addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(bean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filtering-list")
    //value2,value3
    public MappingJacksonValue retrieveBeanList(){
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
                .filterOutAllExcept("value2","value3");

        FilterProvider filters=new SimpleFilterProvider()
                .addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }
}
