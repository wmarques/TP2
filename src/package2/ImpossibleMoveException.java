package package2;

/**
 * Exception that will be throw if an impossible move (out of the maze or into a wall) is made.
 * @author William Marques, Alexandre Bruneau
 *
 */
public class ImpossibleMoveException extends Exception {
	public ImpossibleMoveException(String message) {
		super(message);
	}
}
