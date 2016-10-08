import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVInviteAccount;
import com.tencent.av.gaudio.AVInvitePSTNPhone;
import com.tencent.av.gaudio.AVUserInfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gin
  extends Handler
{
  public gin(QQGAudioCtrl paramQQGAudioCtrl, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    int i;
    Object localObject;
    long l3;
    long l1;
    int j;
    int m;
    int k;
    int n;
    boolean bool;
    label221:
    label259:
    label638:
    label873:
    label1092:
    label1401:
    label1504:
    label1667:
    label1742:
    label1799:
    label2087:
    do
    {
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioCtrl", 2, "handleMessage-->Message is empty!");
          }
          return;
        }
        finally {}
        if (this.a.mVideoController == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioCtrl", 2, "handleMessage-->mVideoControl = null");
          }
        }
        else
        {
          i = paramMessage.what;
          localObject = (gio)paramMessage.obj;
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQGAudioCtrl", 2, "handleMessage-->NativeEventParams is null");
            }
          }
          else
          {
            paramMessage = ((gio)localObject).jdField_a_of_type_ArrayOfByte;
            l3 = ((gio)localObject).jdField_a_of_type_Long;
            l1 = ((gio)localObject).jdField_b_of_type_Long;
            j = ((gio)localObject).jdField_a_of_type_Int;
            m = ((gio)localObject).jdField_b_of_type_Int;
            k = ((gio)localObject).c;
            n = ((gio)localObject).e;
            if ((i == 61) || (i == 43) || (!QLog.isColorLevel())) {
              break label3163;
            }
            StringBuilder localStringBuilder = new StringBuilder().append("GroupId= ").append(l1).append(" ,multiAVType = ").append(j).append(" ,MultiSubType = ").append(m).append(" ,relationType = ").append(k).append(" ,info = ").append(l3).append(" ,detail is null? ");
            if (paramMessage != null) {
              break label3779;
            }
            bool = true;
            QLog.d("QQGAudioCtrl", 2, bool + " ,eventId = " + i + " ,buflen = " + n);
            break label3163;
            if (QLog.isColorLevel())
            {
              QLog.e("QQGAudioCtrl", 2, "Wrong type of eventid=" + i);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("QQGAudioCtrl", 2, "OnMemberJoin Or OnMemberOut");
              }
              if (paramMessage == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("QQGAudioCtrl", 2, "GroupId= " + l1 + " multiAVType=" + j + " MultiSubType=" + m + " relationType=" + k + " info=" + l3 + " eventId=" + i);
                }
              }
              else
              {
                paramMessage = this.a.getAVInfoFromByte(paramMessage, n);
                if (paramMessage == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("QQGAudioCtrl", 2, "Can not get AVUserInfo");
                  }
                }
                else if ((paramMessage.jdField_a_of_type_Int == 0) || ((paramMessage.jdField_a_of_type_Int == 1) && (paramMessage.jdField_b_of_type_Int == 3) && (i == 70)) || ((paramMessage.jdField_a_of_type_Int == 1) && (i == 71)))
                {
                  this.a.mVideoController.a(paramMessage, l1, i, k, l3, new int[] { j });
                }
                else if (QLog.isColorLevel())
                {
                  QLog.e("QQGAudioCtrl", 2, "onMAVMemberInOrOut --> WRONG INFO. Info = " + paramMessage.toString());
                  continue;
                  if ((paramMessage == null) || (paramMessage.length < 8))
                  {
                    if (QLog.isColorLevel())
                    {
                      localObject = new StringBuilder().append("GroupId= ").append(l1).append(" multiAVType=").append(j).append(" MultiSubType=").append(m).append(" relationType=").append(k).append(" info=").append(l3).append(" eventId=").append(i).append(" detail==null");
                      if (paramMessage != null) {
                        break label3785;
                      }
                      bool = true;
                      QLog.e("QQGAudioCtrl", 2, bool);
                    }
                  }
                  else
                  {
                    long l2 = this.a.getLongFromByte(paramMessage);
                    if (l2 == 0L)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("QQGAudioCtrl", 2, "handleMessage--> can not get the uin");
                      }
                    }
                    else
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("QQGAudioCtrl", 2, "UserUin=" + l2 + " eventid=" + i);
                      }
                      this.a.mVideoController.a(l1, l2, i, k, l3, j);
                      continue;
                      this.a.mVideoController.b(l1, k, i);
                      continue;
                      if ((paramMessage == null) || (paramMessage.length < 8))
                      {
                        if (QLog.isColorLevel())
                        {
                          localObject = new StringBuilder().append("GroupId= ").append(l1).append(" multiAVType=").append(j).append(" MultiSubType=").append(m).append(" relationType=").append(k).append(" info=").append(l3).append(" eventId=").append(i).append(" detail==null");
                          if (paramMessage != null) {
                            break label3791;
                          }
                          bool = true;
                          QLog.e("QQGAudioCtrl", 2, bool);
                        }
                      }
                      else if (k != 1)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.e("QQGAudioCtrl", 2, "Why Discussion AVChat can recv VideoSrcType Change???????");
                        }
                      }
                      else
                      {
                        l2 = this.a.getLongFromByte(paramMessage);
                        if (QLog.isColorLevel()) {
                          QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE-->videoSrcType=" + l3 + "uin =" + l2);
                        }
                        if (j != 10)
                        {
                          this.a.mVideoController.a((int)l3, k, l2, l1);
                          continue;
                          if ((paramMessage == null) || (paramMessage.length < 8))
                          {
                            if (QLog.isColorLevel())
                            {
                              localObject = new StringBuilder().append("GroupId= ").append(l1).append(" multiAVType=").append(j).append(" MultiSubType=").append(m).append(" relationType=").append(k).append(" info=").append(l3).append(" eventId=").append(i).append(" detail==null");
                              if (paramMessage != null) {
                                break label3797;
                              }
                              bool = true;
                              QLog.e("QQGAudioCtrl", 2, bool);
                            }
                          }
                          else
                          {
                            l2 = this.a.getLongFromByte(paramMessage);
                            if (QLog.isColorLevel()) {
                              QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_PPT_UPLOAD_STATE-->uploadType=" + l3 + "uin =" + l2);
                            }
                            this.a.mVideoController.a(l1, l2, k, (int)l3);
                            continue;
                            if (l3 == 8L)
                            {
                              if (k == 1) {
                                this.a.mVideoController.c(l1, 1, j);
                              }
                            }
                            else if (l3 == 7L)
                            {
                              this.a.mVideoController.c(l1, 2, j);
                            }
                            else if (l3 == 32L)
                            {
                              this.a.mVideoController.c(l1, 7, j);
                            }
                            else if (l3 == 35L)
                            {
                              this.a.mVideoController.c(l1, 35, j);
                            }
                            else if (l3 == 42L)
                            {
                              this.a.mVideoController.c(l1, 42, j);
                            }
                            else if (l3 == 43L)
                            {
                              this.a.mVideoController.c(l1, 43, j);
                            }
                            else
                            {
                              if ((l3 <= 200L) || (l3 >= 300L)) {
                                break label3803;
                              }
                              paramMessage = new String(paramMessage);
                              this.a.mVideoController.a(l1, l3, paramMessage);
                              continue;
                              this.a.mVideoController.c(l1, 3, j);
                              continue;
                              if ((((gio)localObject).jdField_a_of_type_ArrayOfByte == null) || (((gio)localObject).jdField_a_of_type_ArrayOfByte.length != 16))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.e("QQGAudioCtrl", 2, "eventId = " + i + ", p.detail buf length incorrect ");
                                }
                              }
                              else
                              {
                                paramMessage = this.a.getAVInfoFromByte(((gio)localObject).jdField_a_of_type_ArrayOfByte, ((gio)localObject).jdField_a_of_type_ArrayOfByte.length);
                                if (i != 140) {
                                  break label3824;
                                }
                                bool = true;
                                if (QLog.isColorLevel()) {
                                  QLog.e("QQGAudioCtrl", 2, "MemberAudioChange : uin = " + paramMessage.jdField_a_of_type_Long + ", accountType = " + paramMessage.jdField_a_of_type_Int + ", pstnstatus = " + paramMessage.jdField_b_of_type_Int + ", isMicOff = " + bool);
                                }
                                this.a.mVideoController.a(paramMessage.jdField_a_of_type_Long, paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, bool);
                                continue;
                                l2 = 0L;
                                if ((((gio)localObject).jdField_a_of_type_ArrayOfByte == null) || (((gio)localObject).jdField_a_of_type_ArrayOfByte.length != 8))
                                {
                                  l1 = l2;
                                  if (!QLog.isColorLevel()) {
                                    break label3830;
                                  }
                                  QLog.e("QQGAudioCtrl", 2, "eventId = " + i + ", p.detail buf length incorrect ");
                                  l1 = l2;
                                  break label3830;
                                  if (QLog.isColorLevel()) {
                                    QLog.e("QQGAudioCtrl", 2, "MeetingControlMode : uin = " + l1 + ", isRoomMicOff = " + bool);
                                  }
                                  this.a.mVideoController.c(l1, bool);
                                }
                                else
                                {
                                  l1 = this.a.getLongFromByte(((gio)localObject).jdField_a_of_type_ArrayOfByte);
                                  break label3830;
                                  if ((((gio)localObject).jdField_a_of_type_ArrayOfByte == null) || (((gio)localObject).jdField_a_of_type_ArrayOfByte.length != 8))
                                  {
                                    if (!QLog.isColorLevel()) {
                                      break;
                                    }
                                    QLog.e("QQGAudioCtrl", 2, "eventId = " + i + ", p.detail buf length incorrect ");
                                  }
                                  for (l1 = 0L;; l1 = this.a.getLongFromByte(((gio)localObject).jdField_a_of_type_ArrayOfByte))
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.e("QQGAudioCtrl", 2, "SetMicByAdmin : uin = " + l1 + ", isMicOff = " + bool);
                                    }
                                    this.a.mVideoController.b(l1, bool);
                                    break;
                                  }
                                  j = (int)l3;
                                  if ((((gio)localObject).jdField_a_of_type_ArrayOfByte == null) || (((gio)localObject).jdField_a_of_type_ArrayOfByte.length != j << 4))
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.e("QQGAudioCtrl", 2, "eventId = " + i + ", p.detail buf length incorrect ");
                                    }
                                  }
                                  else
                                  {
                                    paramMessage = QQGAudioCtrl.access$000(this.a, ((gio)localObject).jdField_a_of_type_ArrayOfByte, 16);
                                    if ((paramMessage != null) && (paramMessage.size() == j))
                                    {
                                      this.a.mVideoController.a(j, paramMessage);
                                      continue;
                                      if ((((gio)localObject).jdField_a_of_type_ArrayOfByte == null) || (((gio)localObject).jdField_a_of_type_ArrayOfByte.length != 16))
                                      {
                                        if (QLog.isColorLevel()) {
                                          QLog.e("QQGAudioCtrl", 2, "eventId = " + i + ", p.detail buf length incorrect ");
                                        }
                                      }
                                      else
                                      {
                                        l1 = this.a.getLongFromByte(((gio)localObject).jdField_a_of_type_ArrayOfByte);
                                        paramMessage = new byte[4];
                                        System.arraycopy(((gio)localObject).jdField_a_of_type_ArrayOfByte, 12, paramMessage, 0, 4);
                                        i = QQGAudioCtrl.access$100(this.a, paramMessage);
                                        if (l3 != 1L) {
                                          break label3868;
                                        }
                                        bool = true;
                                        if (QLog.isColorLevel()) {
                                          QLog.e("QQGAudioCtrl", 2, "onGAudioUserAudioSuspectNoisy : uin = " + l1 + ", isSuspectNoisy = " + bool + ",validDuration = " + i);
                                        }
                                        this.a.mVideoController.a(l1, bool, i);
                                        continue;
                                        if (QLog.isColorLevel()) {
                                          QLog.d("QQGAudioCtrl", 2, "EV_GA_SDK_Creat_SUC.");
                                        }
                                        this.a.mVideoController.d(k, l1);
                                        this.a.mVideoController.H = 0;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    } while (!this.a.mVideoController.j());
    paramMessage = QQGAudioCtrl.access$200(this.a, paramMessage);
    if (k != 2) {
      if (k == 1) {
        break label3874;
      }
    }
    for (;;)
    {
      label2242:
      this.a.onRecvUserList(6, k, l1, paramMessage, l3, j, m, i);
      break;
      label3163:
      label3779:
      label3785:
      label3791:
      label3797:
      label3803:
      label3824:
      label3830:
      label3868:
      label3874:
      do
      {
        i = paramMessage.length;
        break label2242;
        if (k == 3)
        {
          this.a.onRecvDoubleVideoMeeting(i, k, l3);
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QQGAudioCtrl", 2, "OnRecvMultiVideoInvite-->RelationType is null; relationType=" + k);
        break;
        paramMessage = (MeetingInfo)((gio)localObject).jdField_a_of_type_JavaLangObject;
        this.a.mVideoController.a(paramMessage);
        break;
        this.a.mVideoController.a(k, l1, new int[] { j });
        break;
        this.a.mVideoController.c(k, l1);
        break;
        this.a.mVideoController.a(k, l1, 17, (int)((gio)localObject).jdField_a_of_type_Long);
        break;
        this.a.mVideoController.a(k, l1, 16, (int)((gio)localObject).jdField_a_of_type_Long);
        break;
        this.a.mVideoController.a(k, l1, 15, (int)((gio)localObject).jdField_a_of_type_Long);
        break;
        paramMessage = QQGAudioCtrl.access$200(this.a, paramMessage);
        if (paramMessage == null) {}
        for (i = 0;; i = paramMessage.length)
        {
          this.a.onRecvUserList(44, k, l1, paramMessage, 0L, j, 0, i);
          break;
        }
        this.a.mVideoController.a(l1, k, j);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_GET_ROOM_INFO");
        }
        paramMessage = QQGAudioCtrl.access$000(this.a, paramMessage, 16);
        if (paramMessage != null)
        {
          i = (int)l3;
          this.a.onRecvUserList(44, k, l1, paramMessage, 0L, 0, j, i);
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQGAudioCtrl", 2, "infoList is null");
        break;
        this.a.mVideoController.a(l1, k, new int[] { j });
        break;
        this.a.mVideoController.b(61, l3, k);
        break;
        this.a.mVideoController.a(i, l3, l1, k);
        break;
        this.a.mVideoController.b(i, l3, l1, k);
        break;
        this.a.mVideoController.c(i, l3, l1, k);
        break;
        this.a.mVideoController.j(3);
        break;
        this.a.mVideoController.j(4);
        break;
        i = (int)((gio)localObject).jdField_a_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.i("QQGAudioCtrl", 2, "SharpConfigPayload. multi version = " + i);
        }
        BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
        TraeConfigUpdate.a().a("load", i);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        if ((paramMessage == null) || (paramMessage.length == 0)) {
          break;
        }
        paramMessage = new String(paramMessage);
        paramMessage = QQGAudioCtrl.access$300(this.a, paramMessage);
        this.a.mVideoController.a(i, l1, paramMessage);
        break;
        this.a.mVideoController.M();
        break;
        paramMessage = AVInviteAccount.a(paramMessage, n);
        this.a.mVideoController.d(paramMessage);
        break;
        paramMessage = AVInvitePSTNPhone.a(paramMessage, n);
        this.a.mVideoController.e(paramMessage);
        break;
        this.a.mVideoController.N();
        break;
        this.a.mVideoController.O();
        break;
        paramMessage = AVInviteAccount.a(paramMessage, n);
        this.a.mVideoController.f(paramMessage);
        break;
        this.a.mVideoController.P();
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.a(i, l1, null);
        break;
        this.a.mVideoController.V();
        break;
        l1 = 0L;
        break label1799;
        switch (i)
        {
        case 7: 
        case 13: 
        case 36: 
        case 37: 
        case 38: 
        case 9: 
        case 10: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 40: 
        case 41: 
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
        case 60: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 99: 
        case 100: 
        case 105: 
        case 106: 
        case 111: 
        case 112: 
        case 113: 
        case 114: 
        case 115: 
        case 116: 
        case 117: 
        case 118: 
        case 119: 
        case 120: 
        case 125: 
        case 126: 
        case 127: 
        case 128: 
        case 149: 
        case 150: 
        case 151: 
        case 152: 
        case 70: 
        case 71: 
        case 42: 
        case 43: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 101: 
        case 102: 
        case 103: 
        case 104: 
        case 107: 
        case 108: 
        case 109: 
        case 110: 
        case 138: 
        case 139: 
        case 140: 
        case 141: 
        case 142: 
        case 144: 
        case 145: 
        case 30: 
        case 5: 
        case 6: 
        case 124: 
        case 12: 
        case 11: 
        case 31: 
        case 32: 
        case 34: 
        case 35: 
        case 39: 
        case 44: 
        case 45: 
        case 8: 
        case 33: 
        case 61: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 98: 
        case 121: 
        case 122: 
        case 123: 
        case 129: 
        case 130: 
        case 131: 
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 19: 
        case 20: 
        case 24: 
        case 21: 
        case 22: 
        case 23: 
        case 146: 
        case 147: 
        case 148: 
        case 153: 
        default: 
          break label259;
          bool = false;
          break label221;
          bool = false;
          break label638;
          bool = false;
          break label873;
          bool = false;
          break label1092;
          if (l3 == 3L) {
            break label1401;
          }
          if (l3 != 15L) {
            break;
          }
          break label1401;
          bool = false;
          break label1504;
          if (l3 == 0L)
          {
            bool = false;
            break label1667;
          }
          bool = true;
          break;
        case 143: 
          if (l3 == 0L)
          {
            bool = false;
            break label1742;
          }
          bool = true;
          break label1742;
          bool = false;
          break label2087;
        }
      } while (paramMessage != null);
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */