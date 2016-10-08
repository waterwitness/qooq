import android.content.Intent;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.dingdong.DingdongJsApiPlugin.OpenIdData;
import cooperation.dingdong.DingdongOpenIdProvider.Callback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;

public class pha
  implements DingdongOpenIdProvider.Callback
{
  public pha(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong, List paramList)
  {
    if (SelectMemberActivity.a(this.a) == paramLong)
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      Intent localIntent = new Intent();
      if (paramList != null)
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          oidb_0x589.GetUserOpenIdRsp localGetUserOpenIdRsp = (oidb_0x589.GetUserOpenIdRsp)paramList.next();
          if (localGetUserOpenIdRsp.uint32_result.get() == 0)
          {
            DingdongJsApiPlugin.OpenIdData localOpenIdData = new DingdongJsApiPlugin.OpenIdData();
            localOpenIdData.jdField_a_of_type_Int = localGetUserOpenIdRsp.msg_req_id.uint32_req_flag.get();
            localOpenIdData.jdField_a_of_type_Long = localGetUserOpenIdRsp.msg_req_id.uint64_req_uin.get();
            localOpenIdData.jdField_b_of_type_Long = localGetUserOpenIdRsp.msg_req_id.uint64_req_host_uin.get();
            localOpenIdData.jdField_a_of_type_JavaLangString = localGetUserOpenIdRsp.bytes_open_id.get().toStringUtf8();
            localOpenIdData.jdField_b_of_type_JavaLangString = localGetUserOpenIdRsp.bytes_group_open_id.get().toStringUtf8();
            localOpenIdData.c = localGetUserOpenIdRsp.bytes_discuss_open_id.get().toStringUtf8();
            localOpenIdData.d = localGetUserOpenIdRsp.bytes_token.get().toStringUtf8();
            localArrayList.add(localOpenIdData);
          }
        }
        localIntent.putParcelableArrayListExtra("dingdong_param_open_id_result", localArrayList);
      }
      this.a.setResult(-1, localIntent);
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */