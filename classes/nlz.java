import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class nlz
  extends EmoticonPackageDownloadListener
{
  public nlz(MarketFaceItemBuilder paramMarketFaceItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject1 = null;
    if (paramInt != 0)
    {
      localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MarketFaceItemBuilder.Holder)((Iterator)localObject1).next();
        if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new nma(this, (MarketFaceItemBuilder.Holder)localObject2));
        }
      }
    }
    do
    {
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
      return;
      while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (paramEmoticonPackage == null)) {}
      localObject2 = ((EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramEmoticonPackage.epId);
    } while (localObject2 == null);
    Object localObject2 = ((List)localObject2).iterator();
    Emoticon localEmoticon;
    Object localObject3;
    boolean bool;
    if (((Iterator)localObject2).hasNext())
    {
      localEmoticon = (Emoticon)((Iterator)localObject2).next();
      localObject3 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (MarketFaceItemBuilder.Holder)((Iterator)localObject3).next();
          if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
          {
            ChatMessage localChatMessage = ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_Boolean) && (((MarketFaceItemBuilder.Holder)localObject2).e.hasWindowFocus()))
            {
              bool = true;
              label295:
              ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_Boolean = false;
              localObject3 = Boolean.valueOf(bool);
              localObject1 = localObject2;
              localObject2 = localChatMessage;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (((Boolean)localObject3).booleanValue()) {
        if (localObject2 != null)
        {
          localObject2 = ((ChatMessage)localObject2).senderuin;
          ((BaseActivity)this.a.b).runOnUiThread(new nmb(this, localEmoticon, (String)localObject2, (MarketFaceItemBuilder.Holder)localObject1));
        }
      }
      for (;;)
      {
        localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MarketFaceItemBuilder.Holder)((Iterator)localObject1).next();
        if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))) {
          break;
        }
        if (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) {
          ((BaseActivity)this.a.b).runOnUiThread(new nmd(this));
        }
        this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
        return;
        bool = false;
        break label295;
        if ((localEmoticon != null) && (localEmoticon.jobType == 4)) {
          ((BaseActivity)this.a.b).runOnUiThread(new nmc(this, (MarketFaceItemBuilder.Holder)localObject1, localEmoticon));
        }
      }
      localObject2 = null;
      localObject3 = Boolean.valueOf(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nlz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */