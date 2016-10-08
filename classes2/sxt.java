import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;

public class sxt
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  public sxt(MediaApiPlugin paramMediaApiPlugin, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_JavaLangString = "[]";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_JavaLangString = paramString2;
  }
  
  public void run()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      i = 0;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        int j;
        int i;
        System.gc();
        this.jdField_b_of_type_JavaLangString = "3";
        this.jdField_c_of_type_JavaLangString = "[]";
        if ((this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a != null) && (this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.dismiss();
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        MediaApiPlugin.e(this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin, this.jdField_d_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString);
        return;
        localOutOfMemoryError.put(MediaApiPlugin.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        i += 1;
      }
      if (!isInterrupted()) {
        break label231;
      }
      throw new InterruptedException();
    }
    catch (IOException localIOException)
    {
      this.jdField_b_of_type_JavaLangString = "2";
      this.jdField_c_of_type_JavaLangString = "[]";
      if ((this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.isShowing())) {
        break label207;
      }
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.dismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label362;
      }
      MediaApiPlugin.e(this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin, this.jdField_d_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString);
      return;
      this.jdField_b_of_type_JavaLangString = "0";
      this.jdField_c_of_type_JavaLangString = localIOException.toString();
      if ((this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.isShowing())) {
        break label278;
      }
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.dismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label302;
      }
      MediaApiPlugin.e(this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin, this.jdField_d_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.jdField_b_of_type_JavaLangString = "2";
      this.jdField_c_of_type_JavaLangString = "[]";
      if ((this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.isShowing())) {
        break label438;
      }
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.dismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label462;
      }
      MediaApiPlugin.e(this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin, this.jdField_d_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.mRuntime.a();
      if ((localActivity == null) || (localActivity.isFinishing())) {
        break label527;
      }
      this.jdField_b_of_type_JavaLangString = "1";
      this.jdField_c_of_type_JavaLangString = "[]";
      if ((this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.isShowing())) {
        break label560;
      }
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.dismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label584;
      }
      MediaApiPlugin.e(this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin, this.jdField_d_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
      return;
    }
    finally
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.isShowing())) {
        break label648;
      }
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.dismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label673;
      }
    }
    if (i < j) {
      if (isInterrupted()) {
        throw new InterruptedException();
      }
    }
    label207:
    label231:
    label278:
    label302:
    label362:
    label438:
    label462:
    label527:
    label560:
    label584:
    label648:
    MediaApiPlugin.e(this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin, this.jdField_d_of_type_JavaLangString, 0, this.jdField_c_of_type_JavaLangString);
    for (;;)
    {
      throw ((Throwable)localObject);
      label673:
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */