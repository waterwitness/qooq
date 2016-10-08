package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import svo;
import svp;

public class LoginKeyHelper
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public long a;
  public LoginKeyHelper.AccountInfo a;
  public WtloginHelper a;
  
  public LoginKeyHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$AccountInfo = new LoginKeyHelper.AccountInfo(this);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public LoginKeyHelper.AccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$AccountInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper != null) {
      this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.CancelRequest();
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, LoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$AccountInfo.b))
    {
      if (paramGetLoginKeyListener != null) {
        paramGetLoginKeyListener.a(paramString1, true, 0);
      }
      return;
    }
    svp localsvp = new svp(this, paramGetLoginKeyListener, paramString1);
    FastAuthorize.AuthorizeRequest localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    localAuthorizeRequest.uin.set(Long.parseLong(paramAppInterface.a()));
    localAuthorizeRequest.client_id.set(Long.parseLong(paramString2));
    localAuthorizeRequest.pf.set("");
    paramString2 = AppUtil.a(paramContext);
    localAuthorizeRequest.qqv.set(paramString2);
    localAuthorizeRequest.sdkp.set("a");
    paramString2 = Build.DISPLAY;
    localAuthorizeRequest.os.set(paramString2);
    paramString2 = ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
    localAuthorizeRequest.skey.set(paramString2);
    paramString2 = "";
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramString2 = ((QQAppInterface)paramAppInterface).d();
    }
    for (;;)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localAuthorizeRequest.vkey.set(str);
      localAuthorizeRequest.flags.set(7);
      paramContext = new NewIntent(paramContext, ProtoServlet.class);
      localAuthorizeRequest.apk_sign.set("");
      paramContext.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
      try
      {
        paramContext.putExtra("data", localAuthorizeRequest.toByteArray());
        paramContext.setObserver(localsvp);
        paramAppInterface.startServlet(paramContext);
        return;
        if (!(paramAppInterface instanceof BrowserAppInterface)) {
          continue;
        }
        paramString2 = ((BrowserAppInterface)paramAppInterface).c();
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramGetLoginKeyListener.a(paramString1, false, 55535);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, LoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$AccountInfo.a != null) && (!paramBoolean) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 43200000L))
    {
      if (paramGetLoginKeyListener != null) {
        paramGetLoginKeyListener.a(paramString2, true, 0);
      }
      return true;
    }
    if (this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper == null) {
      this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper = new WtloginHelper(BaseApplicationImpl.getContext());
    }
    byte[] arrayOfByte = null;
    if (paramString3.equals("com.tencent.huayang"))
    {
      arrayOfByte = new byte[16];
      byte[] tmp88_86 = arrayOfByte;
      tmp88_86[0] = -33;
      byte[] tmp93_88 = tmp88_86;
      tmp93_88[1] = 11;
      byte[] tmp98_93 = tmp93_88;
      tmp98_93[2] = -29;
      byte[] tmp103_98 = tmp98_93;
      tmp103_98[3] = -119;
      byte[] tmp108_103 = tmp103_98;
      tmp108_103[4] = 66;
      byte[] tmp113_108 = tmp108_103;
      tmp113_108[5] = 110;
      byte[] tmp118_113 = tmp113_108;
      tmp118_113[6] = 87;
      byte[] tmp124_118 = tmp118_113;
      tmp124_118[7] = 53;
      byte[] tmp130_124 = tmp124_118;
      tmp130_124[8] = -16;
      byte[] tmp136_130 = tmp130_124;
      tmp136_130[9] = -77;
      byte[] tmp142_136 = tmp136_130;
      tmp142_136[10] = -121;
      byte[] tmp148_142 = tmp142_136;
      tmp148_142[11] = -112;
      byte[] tmp154_148 = tmp148_142;
      tmp154_148[12] = 46;
      byte[] tmp160_154 = tmp154_148;
      tmp160_154[13] = 51;
      byte[] tmp166_160 = tmp160_154;
      tmp166_160[14] = -96;
      byte[] tmp172_166 = tmp166_160;
      tmp172_166[15] = 62;
      tmp172_166;
    }
    for (;;)
    {
      this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.SetListener(new svo(this, paramGetLoginKeyListener, paramString2));
      int i = this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.GetA1WithA1(paramString1, 16L, 16L, paramString3.getBytes(), 1L, Long.valueOf(paramString4).longValue(), 1L, "5.2".getBytes(), arrayOfByte, new WUserSigInfo(), new WFastLoginInfo());
      if ((i != 64535) && (paramGetLoginKeyListener != null)) {
        paramGetLoginKeyListener.a(paramString2, false, i);
      }
      return true;
      if (paramString3.equals("com.tencent.now"))
      {
        arrayOfByte = new byte[16];
        byte[] tmp294_292 = arrayOfByte;
        tmp294_292[0] = -51;
        byte[] tmp300_294 = tmp294_292;
        tmp300_294[1] = 50;
        byte[] tmp306_300 = tmp300_294;
        tmp306_300[2] = 114;
        byte[] tmp312_306 = tmp306_300;
        tmp312_306[3] = -105;
        byte[] tmp318_312 = tmp312_306;
        tmp318_312[4] = -54;
        byte[] tmp324_318 = tmp318_312;
        tmp324_318[5] = -19;
        byte[] tmp330_324 = tmp324_318;
        tmp330_324[6] = 112;
        byte[] tmp337_330 = tmp330_324;
        tmp337_330[7] = -124;
        byte[] tmp344_337 = tmp337_330;
        tmp344_337[8] = -125;
        byte[] tmp351_344 = tmp344_337;
        tmp351_344[9] = -52;
        byte[] tmp358_351 = tmp351_344;
        tmp358_351[10] = -72;
        byte[] tmp365_358 = tmp358_351;
        tmp365_358[11] = -101;
        byte[] tmp372_365 = tmp365_358;
        tmp372_365[12] = -27;
        byte[] tmp379_372 = tmp372_365;
        tmp379_372[13] = 33;
        byte[] tmp386_379 = tmp379_372;
        tmp386_379[14] = 65;
        byte[] tmp393_386 = tmp386_379;
        tmp393_386[15] = -128;
        tmp393_386;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\LoginKeyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */