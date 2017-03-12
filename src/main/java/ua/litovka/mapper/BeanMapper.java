package ua.litovka.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * copy objects
 */
public final class BeanMapper {

    private static BeanMapper beanMapper = new BeanMapper();
    private static DozerBeanMapper mapper;

    private BeanMapper() {

        List<String> mappingFiles = new ArrayList<>();
        try {

            mappingFiles.add((BeanMapper.class.getClassLoader().getResources("doserjdk8Converter.xml").toString()));
            mappingFiles.add((BeanMapper.class.getClassLoader().getResources("doserMapping.xml").toString()));



        } catch (IOException e) {
            e.printStackTrace();
        }

        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(mappingFiles);
    }

    public static synchronized BeanMapper getInstance() {
        if (beanMapper == null) {
            beanMapper = new BeanMapper();
        }
        return beanMapper;
    }

    public static <T> T singleMapper(Object from, Class<T> toClass) {
        T map = mapper.map(from, toClass);
        return map;
    }

    public static <E, T> List<T> listMapToList(Iterable<E> iterable, Class<T> toClass) {

        List<T> list = new ArrayList<>();
        for (E e : iterable) {
            list.add(mapper.map(e, toClass));
        }
        return list;
    }


}
