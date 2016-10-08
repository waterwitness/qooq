package cooperation.qqfav.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public abstract interface Favorites$IProxy
{
  public abstract int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
  
  public abstract int a(Uri paramUri, String paramString, String[] paramArrayOfString);
  
  public abstract Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
  
  public abstract Uri a(Uri paramUri, ContentValues paramContentValues);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qqfav\content\Favorites$IProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */