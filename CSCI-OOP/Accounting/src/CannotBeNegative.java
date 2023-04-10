import java.io.Serializable;

public class CannotBeNegative extends IllegalArgumentException implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	  public CannotBeNegative ( String message )
	  {
	    super( message );
	  }
	}