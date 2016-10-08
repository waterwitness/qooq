package mqq.database;

public abstract interface DataBaseListener
{
  public abstract void onCreate(EncryptedDatabase paramEncryptedDatabase);
  
  public abstract void onOpen(EncryptedDatabase paramEncryptedDatabase);
  
  public abstract void onUpgrade(EncryptedDatabase paramEncryptedDatabase, int paramInt1, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\database\DataBaseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */