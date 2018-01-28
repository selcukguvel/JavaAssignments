import java.util.Date;
import java.util.UUID;
/**
 *The PostInterface has methods which
 *are common for all post types.
 * @author Muhammet Selcuk Guvel
 */
public interface PostInterface {
	/**
	 * Sets the text content
	 * @param textContent the text content of the post
	 */
	void setText(String textContent);
	/**
	 * @return the post's text content
	 */
	String getText();
	/**
	 * @return the UUID of the post
	 */
	UUID getID();
	/**
	 * @return the date of the post
	 */
	Date getDate();
}
