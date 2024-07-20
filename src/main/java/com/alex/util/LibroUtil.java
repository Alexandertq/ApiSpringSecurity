package com.alex.util;



import com.alex.entity.Libro;
import com.alex.mapper.LibroMapper;

import java.util.ArrayList;
import java.util.Collection;

public class LibroUtil
{

    public static Collection<LibroMapper> convertList(Collection<Libro> libros)
    {
        Collection<LibroMapper> mappers=new ArrayList<>();

        for(Libro libro:libros)
        {
            LibroMapper libroMapper=new LibroMapper(libro);
            mappers.add(libroMapper);
        }

        return mappers;
    }

    public static LibroMapper convertEntity(Libro libro)
    {
        LibroMapper libroMapper=new LibroMapper(libro);
        return libroMapper;
    }

}
