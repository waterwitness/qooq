import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class tfd
  implements Runnable
{
  public tfd(EmoticonManager paramEmoticonManager, Emoticon paramEmoticon)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject3;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey))
    {
      localObject3 = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.getMapKey());
      if (localObject3 != null)
      {
        ??? = localObject3;
        if (!TextUtils.isEmpty(((Emoticon)localObject3).encryptKey)) {}
      }
      else
      {
        ??? = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId });
      }
      if ((??? != null) && (!TextUtils.isEmpty(((Emoticon)???).encryptKey))) {
        this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey = ((Emoticon)???).encryptKey;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.getMapKey(), this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
    Object localObject5;
    Object localObject6;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b)
    {
      localObject3 = (List)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b.get(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localObject3 != null)
      {
        localObject5 = ((List)localObject3).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (Emoticon)((Iterator)localObject5).next();
          if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId.equals(((Emoticon)localObject6).eId))
          {
            ((List)localObject3).remove(localObject6);
            ((List)localObject3).add(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b.put(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, localObject3);
      }
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon instanceof EmoticonKeywordForCloud)) {
        break label808;
      }
      localObject5 = new Emoticon();
      ((Emoticon)localObject5).eId = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
      ((Emoticon)localObject5).encryptKey = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey;
      ((Emoticon)localObject5).epId = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
      ((Emoticon)localObject5).name = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
      ((Emoticon)localObject5).magicValue = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue;
      ((Emoticon)localObject5).keywords = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.keywords;
      ((Emoticon)localObject5).keyword = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.keyword;
      ((Emoticon)localObject5).jobType = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType;
      ((Emoticon)localObject5).isSound = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound;
      ((Emoticon)localObject5).height = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.height;
      ((Emoticon)localObject5).value = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.value;
      ((Emoticon)localObject5).width = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.width;
      ((Emoticon)localObject5).businessExtra = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.businessExtra;
      ((Emoticon)localObject5).setStatus(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.getStatus());
      ((Emoticon)localObject5).setId(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.getId());
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a((Entity)localObject5);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    try
    {
      ((EntityTransaction)localObject3).a();
      if (((Emoticon)localObject5).keywords != null) {}
      for (??? = new JSONArray(((Emoticon)localObject5).keywords);; ??? = new JSONArray())
      {
        if (((JSONArray)???).length() < 1)
        {
          if ((((Emoticon)localObject5).keyword != null) && (((Emoticon)localObject5).keyword.length() > 0)) {
            ((JSONArray)???).put(((Emoticon)localObject5).keyword);
          }
          if ((((Emoticon)localObject5).name != null) && (((Emoticon)localObject5).name.length() > 0) && (!((Emoticon)localObject5).name.equals(((Emoticon)localObject5).keyword))) {
            ((JSONArray)???).put(((Emoticon)localObject5).name);
          }
        }
        int j = ((JSONArray)???).length();
        int i = 0;
        while (i < j)
        {
          localObject6 = ((JSONArray)???).getString(i);
          EmoticonKeyword localEmoticonKeyword = new EmoticonKeyword();
          localEmoticonKeyword.epId = ((Emoticon)localObject5).epId;
          localEmoticonKeyword.eId = ((Emoticon)localObject5).eId;
          localEmoticonKeyword.name = ((Emoticon)localObject5).name;
          localEmoticonKeyword.encryptKey = ((Emoticon)localObject5).encryptKey;
          if (!TextUtils.isEmpty((CharSequence)localObject6)) {
            localEmoticonKeyword.keyword = ((String)localObject6).toUpperCase();
          }
          localEmoticonKeyword.isSound = ((Emoticon)localObject5).isSound;
          localEmoticonKeyword.jobType = ((Emoticon)localObject5).jobType;
          localEmoticonKeyword.width = ((Emoticon)localObject5).width;
          localEmoticonKeyword.height = ((Emoticon)localObject5).height;
          localEmoticonKeyword._index = ((EmoticonKeywordForCloud)this.jdField_a_of_type_ComTencentMobileqqDataEmoticon)._index;
          localEmoticonKeyword.valid = true;
          localEmoticonKeyword.businessExtra = ((Emoticon)localObject5).businessExtra;
          this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticonKeyword);
          i += 1;
        }
        localObject4 = finally;
        throw ((Throwable)localObject4);
      }
      ((EntityTransaction)localObject4).c();
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmoticonManager", 2, "saveEmoticon json parse error", localJSONException);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmoticonManager", 2, "saveEmoticon error", localException);
      }
      return;
    }
    finally
    {
      ((EntityTransaction)localObject4).b();
    }
    label808:
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */