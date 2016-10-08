import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ghf
  extends Handler
{
  public ghf(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    byte[] arrayOfByte1;
    long l;
    String str;
    for (;;)
    {
      byte[] arrayOfByte2;
      try
      {
        i = paramMessage.what;
        paramMessage = (ghg)paramMessage.obj;
        if (paramMessage == null) {
          return;
        }
        arrayOfByte1 = paramMessage.jdField_a_of_type_ArrayOfByte;
        l = paramMessage.jdField_a_of_type_Long;
        str = CharacterUtil.a(paramMessage.jdField_b_of_type_Long);
        arrayOfByte2 = paramMessage.jdField_b_of_type_ArrayOfByte;
        if ((!QLog.isColorLevel()) || (i == 15)) {
          break;
        }
        QLog.d("NativeEventHandler", 2, "handleMessage eventId: " + i + ", info: " + l + ", fromUin:" + str);
      }
      finally {}
      VcControllerImpl.access$000(this.a, i, paramMessage);
      continue;
      this.a.mEventListener.f(str);
      continue;
      if (l == 1L)
      {
        VcControllerImpl.access$102(this.a, true);
        label159:
        if (l <= 1000L) {
          break label243;
        }
        this.a.mfAudio2VideoFlag = true;
        if (l - 1000L != 1L) {
          break label231;
        }
        VcControllerImpl.access$102(this.a, true);
      }
      for (;;)
      {
        this.a.mEventListener.k(str);
        break;
        if (l != 0L) {
          break label159;
        }
        VcControllerImpl.access$102(this.a, false);
        break label159;
        label231:
        VcControllerImpl.access$102(this.a, false);
        continue;
        label243:
        this.a.mfAudio2VideoFlag = false;
      }
      if (!VcControllerImpl.access$200(this.a))
      {
        this.a.mEventListener.a(str, arrayOfByte1, (int)l, VcControllerImpl.access$300(this.a), VcControllerImpl.access$400(this.a), VcControllerImpl.access$500(this.a), paramMessage.jdField_a_of_type_Int);
        continue;
        if (l == 1L)
        {
          this.a.mEventListener.a(str, arrayOfByte2, 1L);
        }
        else
        {
          this.a.mEventListener.a(str, arrayOfByte1, 0L);
          continue;
          label353:
          this.a.mEventListener.a(str, i, paramMessage.c);
          continue;
          this.a.mEventListener.q(str);
          continue;
          this.a.mEventListener.a(str, 12, 0L);
          continue;
          this.a.mEventListener.l(str);
          continue;
          this.a.mEventListener.m(str);
          continue;
          this.a.mEventListener.n(str);
          continue;
          this.a.mEventListener.o(str);
          continue;
          this.a.mEventListener.r(str);
          continue;
          this.a.mEventListener.t(str);
          continue;
          this.a.mEventListener.u(str);
          continue;
          this.a.mEventListener.a(i - 19, str);
          continue;
          this.a.mEventListener.a(str, true);
          continue;
          this.a.mEventListener.a(str, false);
          continue;
          this.a.mEventListener.g(str);
          continue;
          this.a.mEventListener.h(str);
          continue;
          this.a.mEventListener.i(str);
          continue;
          this.a.mEventListener.j(str);
          continue;
          this.a.mEventListener.v(str);
          continue;
          this.a.mEventListener.d(true);
          continue;
          this.a.mEventListener.d(false);
          continue;
          if (AVReport.a().a) {
            AVReport.a().k = SystemClock.elapsedRealtime();
          }
          for (;;)
          {
            this.a.mEventListener.e(true);
            break;
            AVReport.a().z = SystemClock.elapsedRealtime();
          }
          this.a.mEventListener.d(arrayOfByte1, l);
          continue;
          this.a.mEventListener.w(str);
          continue;
          this.a.mEventListener.b(str, (int)l, paramMessage.c, paramMessage.jdField_a_of_type_ArrayOfByte);
          continue;
          this.a.mEventListener.a(str, (int)l, paramMessage.c, paramMessage.jdField_a_of_type_ArrayOfByte);
          continue;
          this.a.mEventListener.b(str, arrayOfByte1, l);
          continue;
          this.a.mEventListener.c(str, arrayOfByte1, l);
        }
      }
    }
    switch ((int)paramMessage.c)
    {
    }
    for (;;)
    {
      this.a.mEventListener.a(str, paramMessage.d, i);
      break;
      this.a.mEventListener.s(str);
      break;
      this.a.mEventListener.f(str, (int)l);
      break;
      VcControllerImpl.access$102(this.a, true);
      this.a.mEventListener.d(str, (int)l);
      break;
      VcControllerImpl.access$102(this.a, true);
      this.a.mEventListener.e(str, (int)l);
      break;
      this.a.mEventListener.A(str);
      this.a.mEventListener.j(2048);
      break;
      this.a.mEventListener.j(3);
      break;
      this.a.mEventListener.j(4);
      break;
      i = (int)paramMessage.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
      }
      BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
      TraeConfigUpdate.a().a("load", i);
      break;
      this.a.mEventListener.h(str, (int)l);
      break;
      this.a.onAudioData(arrayOfByte1);
      break;
      this.a.mEventListener.a(paramMessage.jdField_a_of_type_Long, paramMessage.jdField_b_of_type_Long);
      break;
      this.a.mEventListener.a(paramMessage.jdField_a_of_type_Long, paramMessage.jdField_a_of_type_ArrayOfByte);
      break;
      this.a.mEventListener.a(str, (int)l, paramMessage.jdField_a_of_type_ArrayOfByte);
      break;
      if (l != 1L) {
        break;
      }
      this.a.mEventListener.z(new String(arrayOfByte1));
      break;
      switch (i)
      {
      case 17: 
      case 71: 
      case 1: 
      case 2: 
      case 60: 
      case 61: 
      case 3: 
      case 6: 
      case 15: 
      case 16: 
      case 24: 
      case 8: 
      case 10: 
      case 7: 
      case 9: 
      case 13: 
      case 14: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 25: 
      case 26: 
      case 105: 
      case 106: 
      case 107: 
      case 108: 
      case 30: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 95: 
      case 68: 
      case 67: 
      case 69: 
      case 72: 
      case 73: 
      case 75: 
      case 74: 
      case 76: 
      case 83: 
      case 91: 
      case 92: 
      case 93: 
      case 100: 
      case 96: 
      case 102: 
      case 103: 
      case 110: 
      case 111: 
      case 5: 
      case 11: 
      case 12: 
      case 23: 
      case 27: 
      case 28: 
      case 29: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 70: 
      case 77: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      case 94: 
      case 97: 
      case 98: 
      case 99: 
      case 101: 
      case 104: 
      case 109: 
      default: 
        break;
      case 4: 
        i = (int)l;
        switch (i)
        {
        }
        break label353;
        i = 0;
        continue;
        i = 2;
        continue;
        i = 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ghf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */