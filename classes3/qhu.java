import android.view.View;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class qhu
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public WeakReference b;
  
  public qhu(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler, View paramView, TroopQZoneUploadAlbumHandler.Callback paramCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public TroopQZoneUploadAlbumHandler.Callback a()
  {
    return (TroopQZoneUploadAlbumHandler.Callback)this.b.get();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */