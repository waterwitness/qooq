import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.store.ApolloBoxData;
import com.tencent.mobileqq.apollo.store.ApolloBoxData.ApolloBoxDataItem;
import com.tencent.mobileqq.apollo.store.ApolloWrapperCardView;
import com.tencent.mobileqq.apollo.store.BoxViewBuilder;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.apollo.view.SimpleFrameZipDecoder;
import com.tencent.mobileqq.apollo.view.SimpleFrameZipDecoder.onFrameDecodeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class psc
  extends RelativeLayout
  implements SimpleFrameZipDecoder.onFrameDecodeListener, Runnable
{
  private int jdField_a_of_type_Int;
  private final ApolloBoxData jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData;
  private final SimpleFrameZipDecoder jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder;
  private final List jdField_a_of_type_JavaUtilList;
  private final List b;
  
  public psc(Context paramContext, ApolloBoxData paramApolloBoxData)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder = new QQFrameZipDecoder(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData = paramApolloBoxData;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder.b();
    super.removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ApolloWrapperCardView)localIterator.next()).a(ApolloWrapperCardView.b, paramBitmap);
    }
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 8)
    {
      paramBitmap = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramBitmap.hasNext()) {
        ((ApolloWrapperCardView)paramBitmap.next()).a(ApolloWrapperCardView.d, null);
      }
    }
  }
  
  public void a(BoxViewBuilder paramBoxViewBuilder)
  {
    if ((paramBoxViewBuilder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder.a(70, "http://cmshow.gtimg.cn/client/zip/apollo_float_card_2016_06_15.zip", QQFrameZipDecoder.a("http://cmshow.gtimg.cn/client/zip/apollo_float_card_2016_06_15.zip"), false);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList.size())
        {
          ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = (ApolloBoxData.ApolloBoxDataItem)this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxData.jdField_a_of_type_JavaUtilList.get(i);
          ApolloWrapperCardView localApolloWrapperCardView = paramBoxViewBuilder.a(i, localApolloBoxDataItem);
          if (localApolloWrapperCardView != null)
          {
            localApolloWrapperCardView.setClickable(true);
            super.addView(localApolloWrapperCardView);
            if ((!localApolloBoxDataItem.b) && (localApolloBoxDataItem.a)) {
              this.jdField_a_of_type_JavaUtilList.add(localApolloWrapperCardView);
            }
            this.b.add(localApolloWrapperCardView);
          }
          i += 1;
        }
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ApolloWrapperCardView)localIterator.next()).a(ApolloWrapperCardView.c, null);
    }
  }
  
  public void c()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((ApolloWrapperCardView)localIterator.next()).a(ApolloWrapperCardView.jdField_a_of_type_Int, null);
      }
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        super.post(this);
      }
    }
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */