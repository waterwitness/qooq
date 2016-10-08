import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Iterator;
import java.util.List;

public class rks
  implements URLDrawable.URLDrawableListener
{
  public rks(EmotionPreviewLayout paramEmotionPreviewLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText == null) || (TextUtils.isEmpty(this.a.b)) || (!this.a.b.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString()))) {}
    label204:
    label210:
    do
    {
      return;
      EmoticonKeywordForCloud localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)paramURLDrawable.getTag();
      if ((localEmoticonKeywordForCloud != null) && (this.a.b.equals(localEmoticonKeywordForCloud.inputKeyword)))
      {
        paramURLDrawable.setTag(localEmoticonKeywordForCloud);
        localEmoticonKeywordForCloud.loadedType = 3;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          paramThrowable = EmotionPreviewLayout.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder().append("emotion onLoadFialed, keyword:").append(this.a.b).append(", epid_eid:");
          if (localEmoticonKeywordForCloud.epId == null) {
            break label204;
          }
          paramURLDrawable = localEmoticonKeywordForCloud.epId;
          localStringBuilder = localStringBuilder.append(paramURLDrawable).append("_");
          if (localEmoticonKeywordForCloud.eId == null) {
            break label210;
          }
        }
        for (paramURLDrawable = localEmoticonKeywordForCloud.eId;; paramURLDrawable = "~")
        {
          QLog.e(paramThrowable, 2, paramURLDrawable);
          this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10002));
          return;
          paramURLDrawable = "~";
          break;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(EmotionPreviewLayout.jdField_a_of_type_JavaLangString, 2, "emotion onLoadFialed, k:null, keyword:" + this.a.b);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText == null) || (TextUtils.isEmpty(this.a.b)) || (!this.a.b.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString()))) {}
    do
    {
      return;
      paramURLDrawable = (EmoticonKeywordForCloud)paramURLDrawable.getTag();
    } while ((paramURLDrawable == null) || (!this.a.b.equals(paramURLDrawable.inputKeyword)));
    paramURLDrawable.loadedType = 2;
    Object localObject;
    if (this.a.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      EmoticonKeyword localEmoticonKeyword;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEmoticonKeyword = (EmoticonKeyword)((Iterator)localObject).next();
      } while ((!localEmoticonKeyword.eId.equals(paramURLDrawable.eId)) || (!localEmoticonKeyword.epId.equals(paramURLDrawable.epId)));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.a.jdField_a_of_type_JavaUtilList.add(paramURLDrawable);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10002));
        return;
        localObject = (EmoticonManager)EmotionPreviewLayout.a(this.a).getManager(13);
        if (localObject != null)
        {
          ((EmoticonManager)localObject).b(paramURLDrawable);
          ((EmoticonManager)localObject).a(paramURLDrawable);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */