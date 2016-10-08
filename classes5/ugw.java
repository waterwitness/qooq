import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DataAdapter;
import java.util.HashMap;

public class ugw
  extends DataAdapter
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  ugw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public HashMap a(String paramString)
  {
    if ("RealShortVideo.Record".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_cameraID", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("param_hasMultiSegments", String.valueOf(this.jdField_a_of_type_Boolean));
      return paramString;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */