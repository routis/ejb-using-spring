package routis.examples;

import lombok.NonNull;

/**
 * A dummy interface
 */
public interface Echo {

    @NonNull
    String echo(@NonNull String msg);

}
