import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class tta
  implements Runnable
{
  public tta(PicPreDownloader paramPicPreDownloader, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int k = 0;
    for (;;)
    {
      int j;
      int i;
      PicReq localPicReq;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilList.iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label290;
        }
        localPicReq = (PicReq)localIterator.next();
        switch (localPicReq.r)
        {
        case 4: 
          k += 1;
          localPicReq.q = localPicReq.r;
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.q));
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.d.add(0, localPicReq);
          localPicReq.q = localPicReq.r;
          this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.q));
        }
      }
      i += 1;
      localPicReq.q = localPicReq.r;
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.q));
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.b.add(0, localPicReq);
      continue;
      j += 1;
      localPicReq.q = localPicReq.r;
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilMap.put(localPicReq.a.g, Integer.valueOf(localPicReq.q));
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.c.add(0, localPicReq);
      continue;
      label290:
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.jdField_a_of_type_JavaUtilList.clear();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): totalCount=" + this.jdField_a_of_type_Int + " countOfC2C=" + i + " countOfDiscussion=" + j + " countOfGroup=" + k);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */