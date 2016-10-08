package com.tencent.mobileqq.bubble;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BubbleDiyHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "BubbleDiyHandler";
  public static final int b = 1;
  public static final String b = "bubble.";
  
  public BubbleDiyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("bubble.1"))
    {
      bool = paramFromServiceMsg.isSuccess();
      localObject = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      if (QLog.isColorLevel()) {
        QLog.d("BubbleDiyHandler", 2, "key_seq=" + (String)localObject + " isSuccess=" + bool + " resultCode=" + paramFromServiceMsg.getResultCode());
      }
      if (bool) {
        paramFromServiceMsg = new BubbleDiyComu.Bubble_Rsp();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          boolean bool;
          paramFromServiceMsg = (BubbleDiyComu.Bubble_Rsp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg != null) {
            if (paramFromServiceMsg.ret.get() != 0L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("BubbleDiyHandler", 2, "DiyText...fetch key 回包 sso 成功 ，server 失败，ret = " + paramFromServiceMsg.ret.get());
              }
              super.a(paramToServiceMsg, 1, false, null);
              return;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          Object localObject;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BubbleDiyHandler", 2, "DiyText bubble_Rsp is null 业务回包 异常");
            }
            paramFromServiceMsg = null;
          }
          if ((paramFromServiceMsg.rspcmd_0x01.has()) && (paramFromServiceMsg.rspcmd_0x01.user_text_info.has()))
          {
            paramObject = paramFromServiceMsg.rspcmd_0x01.user_text_info.get();
            paramFromServiceMsg = new ArrayList();
            if (paramObject != null)
            {
              paramObject = ((List)paramObject).iterator();
              while (((Iterator)paramObject).hasNext())
              {
                localObject = (BubbleDiyComu.UserTextInfo)((Iterator)paramObject).next();
                if ((((BubbleDiyComu.UserTextInfo)localObject).text.has()) && (((BubbleDiyComu.UserTextInfo)localObject).text_uin.has()) && (((BubbleDiyComu.UserTextInfo)localObject).text_id.has()) && (((BubbleDiyComu.UserTextInfo)localObject).create_ts.has()))
                {
                  localObject = new BubbleDiyText(BubbleDiyText.makeKey("" + ((BubbleDiyComu.UserTextInfo)localObject).text_uin.get(), ((BubbleDiyComu.UserTextInfo)localObject).text_id.get()), ((BubbleDiyComu.UserTextInfo)localObject).text.get(), ((BubbleDiyComu.UserTextInfo)localObject).create_ts.get());
                  paramFromServiceMsg.add(localObject);
                  if (QLog.isColorLevel()) {
                    QLog.d("BubbleDiyHandler", 2, "DiyText item from Net->" + ((BubbleDiyText)localObject).mUinAndTextId + " " + ((BubbleDiyText)localObject).mCreateTime + " " + ((BubbleDiyText)localObject).mText);
                  }
                }
              }
            }
            BubbleDiyFetcher.a().a(this.b, true, paramFromServiceMsg);
            super.a(paramToServiceMsg, 1, true, paramFromServiceMsg);
            return;
          }
          super.a(paramToServiceMsg, 1, false, null);
          return;
        }
        super.a(paramToServiceMsg, 1, false, null);
        return;
        super.a(paramToServiceMsg, 1, false, null);
      } while (!QLog.isColorLevel());
      QLog.d("BubbleDiyHandler", 2, "DiyText isSuccess is false sso通道  异常");
      return;
    }
    QLog.d("BubbleDiyHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
  }
  
  public void a(List paramList, BusinessObserver paramBusinessObserver)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    label195:
    label269:
    for (;;)
    {
      return;
      BubbleDiyComu.Bubble_Req_Comm localBubble_Req_Comm = new BubbleDiyComu.Bubble_Req_Comm();
      localBubble_Req_Comm.platform.set(109L);
      localBubble_Req_Comm.osver.set(Build.VERSION.RELEASE);
      localBubble_Req_Comm.mqqver.set("6.5.5");
      BubbleDiyComu.Bubble_GetDiyText_Req localBubble_GetDiyText_Req = new BubbleDiyComu.Bubble_GetDiyText_Req();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      Object localObject;
      if (paramList.hasNext())
      {
        localObject = ((String)paramList.next()).split("_");
        if (localObject.length >= 2) {
          break label195;
        }
      }
      for (;;)
      {
        if (localArrayList.isEmpty()) {
          break label269;
        }
        localBubble_GetDiyText_Req.user_text_info.set(localArrayList);
        paramList = new BubbleDiyComu.Bubble_Req();
        paramList.cmd.set(1);
        paramList.packet_seq.set(System.currentTimeMillis());
        paramList.comm.set(localBubble_Req_Comm);
        paramList.reqcmd_0x01.set(localBubble_GetDiyText_Req);
        paramBusinessObserver = super.a("bubble.1", paramBusinessObserver);
        paramBusinessObserver.putWupBuffer(paramList.toByteArray());
        super.b(paramBusinessObserver);
        return;
        try
        {
          l = Long.parseLong(localObject[0]);
        }
        catch (NumberFormatException paramList)
        {
          try
          {
            long l;
            int i = Integer.parseInt(localObject[1]);
            localObject = new BubbleDiyComu.UserTextInfo();
            ((BubbleDiyComu.UserTextInfo)localObject).text_uin.set(l);
            ((BubbleDiyComu.UserTextInfo)localObject).text_id.set(i);
            localArrayList.add(localObject);
          }
          catch (NumberFormatException paramList)
          {
            paramList.printStackTrace();
          }
          paramList = paramList;
          paramList.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleDiyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */