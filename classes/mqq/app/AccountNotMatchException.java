package mqq.app;

public class AccountNotMatchException
  extends Exception
{
  public AccountNotMatchException(String paramString1, String paramString2)
  {
    super("The current account is " + paramString1 + " instead of " + paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\AccountNotMatchException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */