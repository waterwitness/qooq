import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class lir
  implements Runnable
{
  public lir(FavEmosmManageActivity paramFavEmosmManageActivity, Object paramObject, VipComicMqqManager paramVipComicMqqManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a();
    int i;
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      i = 0;
      if (i < ((List)localObject2).size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((List)localObject2).get(i);
        if (localCustomEmotionData == null) {}
        label248:
        for (;;)
        {
          i += 1;
          break;
          if ((this.jdField_a_of_type_JavaLangObject instanceof PicEmoticonInfo))
          {
            localObject1 = ((PicEmoticonInfo)this.jdField_a_of_type_JavaLangObject).a;
            if ((!TextUtils.isEmpty(localCustomEmotionData.eId)) && (localObject1 != null) && (localCustomEmotionData.eId.equals(((Emoticon)localObject1).eId))) {
              localArrayList.add(localCustomEmotionData);
            }
          }
          else if ((this.jdField_a_of_type_JavaLangObject instanceof FavoriteEmoticonInfo))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_JavaLangObject)) {}
            for (localObject1 = AppConstants.bs + FunnyPicHelper.a(((FavoriteEmoticonInfo)this.jdField_a_of_type_JavaLangObject).m);; localObject1 = ((FavoriteEmoticonInfo)this.jdField_a_of_type_JavaLangObject).m)
            {
              if ((TextUtils.isEmpty(localCustomEmotionData.emoPath)) || (!localCustomEmotionData.emoPath.equals(localObject1))) {
                break label248;
              }
              localArrayList.add(localCustomEmotionData);
              break;
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject1 = new ArrayList();
      i = j;
      if (i < localArrayList.size())
      {
        localObject2 = (CustomEmotionData)localArrayList.get(i);
        if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).resid))
        {
          ((CustomEmotionData)localObject2).RomaingType = "needDel";
          this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.b((CustomEmotionData)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.b.add(((CustomEmotionData)localObject2).resid);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject2).md5);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("FavEmosmManageActivity", 2, "delete from local, Roma Type: " + ((CustomEmotionData)localObject2).RomaingType);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a((CustomEmotionData)localObject2);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject2).md5);
          }
        }
      }
      if (((List)localObject1).size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqManager.b((List)localObject1);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(207, Integer.valueOf(this.jdField_a_of_type_Int)).sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */