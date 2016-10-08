import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.DownloadGftData;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import java.util.Observable;
import java.util.Observer;

public abstract class nrh
  extends BaseBubbleBuilder.ViewHolder
  implements Observer
{
  public Button a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private QQAppInterface a;
  public MessageForTroopGift a;
  public View b;
  public TextView b;
  public View c;
  public TextView c;
  
  public nrh(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (TroopGiftManager.DownloadGftData)paramObject;
    if ((paramObservable.a.equals(TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift))) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading)) {
      this.c.post(new nri(this, paramObservable));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */