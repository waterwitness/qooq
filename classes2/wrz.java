import android.database.Cursor;
import android.os.Parcel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.datamodel.FriendGroup;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import com.tencent.open.component.cache.database.DbCacheData.Structure;

public final class wrz
  implements DbCacheData.DbCreator
{
  public wrz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return 0;
  }
  
  public FriendGroup a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new FriendGroup();
    ((FriendGroup)localObject).a(paramCursor);
    paramCursor.recycle();
    return (FriendGroup)localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public DbCacheData.Structure[] a()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("groupId", "INTEGER UNIQUE"), new DbCacheData.Structure("data", "BLOB") };
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */