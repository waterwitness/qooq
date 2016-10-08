import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqfav.QfavHelper.AsyncFavoritesProvider;

public class ygk
  implements Runnable
{
  public ygk(QfavHelper.AsyncFavoritesProvider paramAsyncFavoritesProvider)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (this.a.a == null)
    {
      this.a.a(false, this.a.a);
      return;
    }
    long l1 = this.a.a.getLong("req_opt_type", -1L);
    long l2 = this.a.a.getLong("req_biz_type", -1L);
    Object localObject1 = this.a.a.getString("req_biz_key");
    Object localObject3 = this.a.a.getString("req_fav_uin");
    if ((-1L == l1) || (-1L == l2) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject3)))
    {
      this.a.a(false, this.a.a);
      return;
    }
    Object localObject2 = BaseApplication.getContext().getContentResolver();
    if (localObject2 == null)
    {
      this.a.a(false, this.a.a);
      return;
    }
    Bundle localBundle = new Bundle(this.a.a);
    if (1L == l1) {
      bool3 = bool4;
    }
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            localObject3 = Uri.parse("content://qq.favorites/biz_related/" + (String)localObject3);
            bool3 = bool4;
            str = "" + l2;
            bool3 = bool4;
            localObject1 = ((ContentResolver)localObject2).query((Uri)localObject3, new String[] { "mUuid" }, "mBizType=? and mBizKey=?", new String[] { str, localObject1 }, null);
            bool2 = bool1;
            if (localObject1 != null)
            {
              bool2 = bool1;
              bool3 = bool4;
              if (((Cursor)localObject1).moveToFirst())
              {
                bool3 = bool4;
                localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("mUuid"));
                bool2 = bool1;
                if (localObject2 == null) {}
              }
            }
          }
          catch (Exception localException1)
          {
            String str;
            ContentValues localContentValues;
            bool1 = bool3;
            localException1.printStackTrace();
            continue;
          }
          try
          {
            localBundle.putString("rsp_fav_id", SecurityUtile.a((String)localObject2));
            bool2 = true;
            bool1 = bool2;
            if (localObject1 != null)
            {
              bool3 = bool2;
              ((Cursor)localObject1).close();
              bool1 = bool2;
            }
            this.a.a(bool1, localBundle);
            return;
          }
          catch (Exception localException2)
          {
            bool1 = true;
          }
        }
        if (2L == l1)
        {
          bool3 = bool4;
          if (((ContentResolver)localObject2).delete(Uri.parse("content://qq.favorites/biz_related/" + (String)localObject3), "mBizType=? and mBizKey=?", new String[] { "" + l2, localObject1 }) <= 0) {
            break label642;
          }
          bool1 = true;
          break label639;
        }
        bool1 = bool5;
      } while (3L != l1);
      bool3 = bool4;
      str = this.a.a.getString("req_fav_id");
      bool1 = bool5;
      bool3 = bool4;
    } while (TextUtils.isEmpty(str));
    boolean bool3 = bool4;
    localContentValues = new ContentValues();
    bool3 = bool4;
    localContentValues.put("mBizType", Long.valueOf(l2));
    bool3 = bool4;
    localContentValues.put("mBizKey", (String)localObject1);
    bool3 = bool4;
    localContentValues.put("mUuid", str);
    bool3 = bool4;
    localObject1 = ((ContentResolver)localObject2).insert(Uri.parse("content://qq.favorites/biz_related/" + (String)localObject3), localContentValues);
    if (localObject1 != null) {}
    for (bool1 = bool2;; bool1 = false) {
      break;
    }
    for (;;)
    {
      label639:
      break;
      label642:
      bool1 = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ygk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */