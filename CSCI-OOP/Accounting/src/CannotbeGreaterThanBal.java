import java.io.Serializable;

public class CannotbeGreaterThanBal extends IllegalArgumentException implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	  public CannotbeGreaterThanBal ( String message )
	  {
	    super( message );
	  }
}