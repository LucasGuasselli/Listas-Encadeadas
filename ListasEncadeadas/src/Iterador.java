/*
 * @author Lucas Guasselli
 * @since 19/11/2016
 * @version 1.0
 */
import java.util.Iterator;

public interface Iterador extends Iterator<String> {
	void insert(String dado);
	void append(String dado);
}//fecha iterator
