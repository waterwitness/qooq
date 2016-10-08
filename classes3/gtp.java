import com.tencent.av.funchat.magicface.MagicfaceManagerForAV.GetResListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class gtp
  implements MagicfaceManagerForAV.GetResListener
{
  gtp(gto paramgto, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
      localPtvTemplateInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      if (paramInt <= 0) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(localPtvTemplateInfo, bool);
      return;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, paramInt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */