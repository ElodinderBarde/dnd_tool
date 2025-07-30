package ch.Elodin.DnD_Tool.service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class SaveService
{


    static <ID, E> void resolveAndSet(
            ID id,
            Function<ID, Optional<E>> finder,
            Consumer<E> setter) {
        if (id != null) {
            finder.apply(id).ifPresent(setter);
        }
    }

}
