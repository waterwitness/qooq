import android.content.Intent;
import android.nfc.NfcAdapter.ReaderCallback;
import android.nfc.Tag;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qwallet.plugin.proxy.BaseNFCProxyActivity;

public class yjv
  implements NfcAdapter.ReaderCallback
{
  public yjv(BaseNFCProxyActivity paramBaseNFCProxyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onTagDiscovered(Tag paramTag)
  {
    Intent localIntent2 = this.a.getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null) {
      localIntent1 = new Intent();
    }
    localIntent1.putExtra("android.nfc.extra.TAG", paramTag);
    this.a.onNewIntent(localIntent1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */