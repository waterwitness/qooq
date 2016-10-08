import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gge
  extends BroadcastReceiver
{
  public gge(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    label11:
    label1016:
    label1232:
    label1740:
    label1761:
    do
    {
      do
      {
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        long l4;
        int k;
        do
        {
          do
          {
            boolean bool;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      String str1;
                      String str2;
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              break label11;
                              do
                              {
                                return;
                              } while (this.a.jdField_a_of_type_ComTencentAvVideoController == null);
                              if (QLog.isColorLevel()) {
                                QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "recv gaudio msg broadcast: " + paramIntent.getAction());
                              }
                              if (paramIntent.getAction().equals("tencent.video.q2v.GvideoMemUntInvite"))
                              {
                                l1 = paramIntent.getLongExtra("groupId", 0L);
                                l2 = paramIntent.getLongExtra("dealMemUin", 0L);
                                paramContext = paramIntent.getStringExtra("invitedId");
                                this.a.a(new Object[] { Integer.valueOf(513), Long.valueOf(l1), Long.valueOf(l2), paramContext });
                                return;
                              }
                              if (paramIntent.getAction().equals("tencent.video.q2v.close_invite_msg_box"))
                              {
                                l1 = paramIntent.getLongExtra("groupId", 0L);
                                this.a.a(new Object[] { Integer.valueOf(515), Long.valueOf(l1) });
                                return;
                              }
                              if (paramIntent.getAction().equals("tencent.video.q2v.close_invite_msg_box_by_invite_id"))
                              {
                                l1 = paramIntent.getLongExtra("groupId", 0L);
                                paramContext = paramIntent.getStringExtra("inviteId");
                                this.a.a(new Object[] { Integer.valueOf(516), Long.valueOf(l1), paramContext });
                                return;
                              }
                              if (!paramIntent.getAction().equals("tencent.video.q2v.MultiVideo")) {
                                break label1232;
                              }
                              i = paramIntent.getIntExtra("type", -1);
                              if (QLog.isColorLevel()) {
                                QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "GAudioMsgReceiver type: " + i);
                              }
                              if (i != 26) {
                                break;
                              }
                              l1 = paramIntent.getLongExtra("discussId", 0L);
                            } while ((!this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a != l1));
                            paramContext = new Intent();
                            paramContext.setAction("tencent.av.v2q.MultiVideo");
                            paramContext.putExtra("type", 25);
                            paramContext.putExtra("relationId", l1);
                            paramContext.putExtra("relationType", 2);
                            paramContext.putExtra("from", "VideoAppInterface1");
                            paramContext.setPackage(this.a.a().getPackageName());
                            this.a.a().sendBroadcast(paramContext);
                            this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.E, this.a.jdField_a_of_type_ComTencentAvVideoController.a, 0, new int[0]);
                            this.a.jdField_a_of_type_ComTencentAvVideoController.a();
                            return;
                            if (i == 27)
                            {
                              paramContext = paramIntent.getByteArrayExtra("buffer");
                              this.a.jdField_a_of_type_ComTencentAvVideoController.b(paramContext);
                              return;
                            }
                            if (i != 30) {
                              break;
                            }
                            paramContext = paramIntent.getByteArrayExtra("buffer");
                            try
                            {
                              this.a.jdField_a_of_type_ComTencentAvVideoController.c(paramContext);
                              return;
                            }
                            catch (UnsatisfiedLinkError paramContext) {}
                          } while (!QLog.isColorLevel());
                          QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "GAudioMsgReceiver TYPE_GAUDIO_AUDIO_C2S_ACK UnsatisfiedLinkError!");
                          return;
                          if (i == 24)
                          {
                            l1 = paramIntent.getLongExtra("discussId", 0L);
                            paramContext = paramIntent.getStringExtra("cmdUin");
                            paramIntent = paramIntent.getStringArrayExtra("uins");
                            this.a.jdField_a_of_type_ComTencentAvVideoController.a(l1, paramContext, paramIntent);
                            return;
                          }
                          if (i != 31) {
                            break label1016;
                          }
                          l1 = paramIntent.getLongExtra("discussId", 0L);
                          paramContext = paramIntent.getStringExtra("cmdUin");
                          paramIntent = paramIntent.getStringArrayExtra("uins");
                          if ((paramIntent != null) && (paramIntent.length != 0)) {
                            break;
                          }
                        } while (!QLog.isColorLevel());
                        QLog.e(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "GAudioMsgReceiver-->uinlist is null");
                        return;
                        str1 = paramIntent[0];
                        str2 = this.a.a();
                        if (QLog.isColorLevel()) {
                          QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_MEMBER_KICKOUT-->discuss id = " + l1 + ", cmdUin = " + paramContext + ", outUin = " + str1 + ", selfUin = " + str2 + ", uinList.size = " + paramIntent.length);
                        }
                        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a == l1) && (str1.compareTo(str2) == 0))
                        {
                          this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.E, this.a.jdField_a_of_type_ComTencentAvVideoController.a, 0, new int[] { this.a.jdField_a_of_type_ComTencentAvVideoController.a().D });
                          paramContext = new Intent();
                          paramContext.setAction("tencent.av.v2q.MultiVideo");
                          paramContext.putExtra("type", 25);
                          paramContext.putExtra("relationId", l1);
                          paramContext.putExtra("relationType", 2);
                          paramContext.putExtra("from", "VideoAppInterface2");
                          paramContext.setPackage(this.a.a().getPackageName());
                          this.a.a().sendBroadcast(paramContext);
                          this.a.jdField_a_of_type_ComTencentAvVideoController.a();
                          return;
                        }
                      } while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().j != 7) || (this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Long != l1) || (str1.compareTo(str2) != 0));
                      this.a.jdField_a_of_type_ComTencentAvVideoController.a().j = 0;
                      this.a.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Long), Integer.valueOf(4) });
                      this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Long = 0L;
                      this.a.jdField_a_of_type_ComTencentAvVideoController.an = 0;
                      return;
                      if (i != 34) {
                        break;
                      }
                      l1 = paramIntent.getLongExtra("relationId", 0L);
                    } while ((!this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) || (l1 != this.a.jdField_a_of_type_ComTencentAvVideoController.a));
                    this.a.jdField_a_of_type_ComTencentAvVideoController.a(1, l1, 0, new int[] { this.a.jdField_a_of_type_ComTencentAvVideoController.a().D });
                    this.a.jdField_a_of_type_ComTencentAvVideoController.a();
                    paramContext = new Intent();
                    paramContext.setAction("tencent.av.v2q.MultiVideo");
                    paramContext.putExtra("MultiAVType", this.a.jdField_a_of_type_ComTencentAvVideoController.a().D);
                    paramContext.putExtra("type", 25);
                    paramContext.putExtra("relationId", l1);
                    paramContext.putExtra("relationType", 1);
                    paramContext.putExtra("from", "VideoAppInterface3");
                    paramContext.setPackage(this.a.a().getPackageName());
                    this.a.a().sendBroadcast(paramContext);
                    return;
                  } while ((i != 35) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean));
                  this.a.jdField_a_of_type_ComTencentAvVideoController.z();
                  return;
                  if (!paramIntent.getAction().equals("tencent.video.q2v.AddDiscussMember")) {
                    break;
                  }
                } while (!paramIntent.getBooleanExtra("result", false));
                l1 = paramIntent.getLongExtra("roomId", this.a.jdField_a_of_type_ComTencentAvVideoController.a);
                paramContext = paramIntent.getStringArrayListExtra("newMemberUin");
                this.a.jdField_a_of_type_ComTencentAvVideoController.a(l1, paramContext);
                return;
                if (!paramIntent.getAction().equals("tencent.video.q2v.SwitchToDiscuss")) {
                  break;
                }
              } while (!paramIntent.getBooleanExtra("result", false));
              l1 = paramIntent.getLongExtra("roomId", 0L);
              paramContext = paramIntent.getLongArrayExtra("memberUin");
              paramIntent = (ArrayList)paramIntent.getExtras().getSerializable("qqPhoneUserList");
              this.a.jdField_a_of_type_ComTencentAvVideoController.a(l1, paramContext, paramIntent);
              return;
              if (!paramIntent.getAction().equals("tencent.video.q2v.GroupSystemMsg")) {
                break label1761;
              }
              i = paramIntent.getIntExtra("type", -1);
              j = paramIntent.getIntExtra("relationType", -1);
              l1 = paramIntent.getLongExtra("relationId", -1L);
              l2 = paramIntent.getLongExtra("userUin", -1L);
              bool = paramIntent.getBooleanExtra("needSendCmd", false);
              if (QLog.isColorLevel()) {
                QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "type=" + i + ", relationid=" + l1 + ", userUin=" + l2);
              }
              if (i != 7) {
                break label1740;
              }
              if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a != l1)) {
                break;
              }
            } while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) && (this.a.d(l1 + "")));
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(1, l1, 0, new int[] { this.a.jdField_a_of_type_ComTencentAvVideoController.a().D });
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(l1, l2, j, i, bool);
            this.a.jdField_a_of_type_ComTencentAvVideoController.a();
            paramContext = new Intent();
            paramContext.setAction("tencent.av.v2q.MultiVideo");
            paramContext.putExtra("type", 25);
            paramContext.putExtra("relationId", l1);
            paramContext.putExtra("relationType", j);
            paramContext.putExtra("MultiAVType", this.a.jdField_a_of_type_ComTencentAvVideoController.a().D);
            paramContext.putExtra("reason", 4);
            paramContext.putExtra("from", "VideoAppInterface4");
            paramContext.setPackage(this.a.a().getPackageName());
            this.a.a().sendBroadcast(paramContext);
            return;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(l1, l2, j, i, bool);
            return;
            if (paramIntent.getAction().equals("tencent.video.q2v.SelectMember"))
            {
              if (QLog.isColorLevel()) {
                QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "ACTION_SELECT_MEMBER");
              }
              paramContext = (ArrayList)paramIntent.getExtras().getSerializable("SelectMemberList");
              if ((paramContext == null) || (paramContext.size() == 0)) {
                if (QLog.isColorLevel()) {
                  QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "VideoConstants.ACTION_SELECT_MEMBER --> no pstn member");
                }
              }
              for (;;)
              {
                i = paramIntent.getIntExtra("InviteCount", 0);
                paramContext = paramIntent.getStringExtra("FirstName");
                if (QLog.isColorLevel()) {
                  QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "ACTION_SELECT_MEMBER --> InviteCount = " + i + " , FirstName = " + paramContext);
                }
                if ((i <= 0) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
                  break;
                }
                this.a.jdField_a_of_type_ComTencentAvVideoController.c(i, paramContext);
                return;
                if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
                  this.a.jdField_a_of_type_ComTencentAvVideoController.b(paramContext);
                }
              }
            }
            if (paramIntent.getAction().equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED"))
            {
              this.a.jdField_a_of_type_ComTencentAvVideoController.i(paramIntent.getBooleanExtra("isResume", false));
              return;
            }
            if (!paramIntent.getAction().equals("tencent.video.q2v.GvideoGift")) {
              break;
            }
            i = paramIntent.getIntExtra("type", -1);
            l1 = paramIntent.getLongExtra("fromUin", -1L);
            l2 = paramIntent.getLongExtra("toUin", -1L);
            j = paramIntent.getIntExtra("count", -1);
            l3 = paramIntent.getLongExtra("seq", -1L);
            l4 = paramIntent.getLongExtra("groupId", -1L);
          } while ((i <= 0) || (l1 <= 0L) || (l2 <= 0L) || (j <= 0) || (l4 <= 0L) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null));
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(i, l1, l2, j, l3, l4);
          return;
          if (!paramIntent.getAction().equals("tencent.video.q2v.GvideoLevelUpgrade")) {
            break;
          }
          i = paramIntent.getIntExtra("type", -1);
          l1 = paramIntent.getLongExtra("fromUin", -1L);
          l2 = paramIntent.getLongExtra("toUin", -1L);
          j = paramIntent.getIntExtra("enable", -1);
          k = paramIntent.getIntExtra("level", -1);
          l3 = paramIntent.getLongExtra("seq", -1L);
          l4 = paramIntent.getLongExtra("groupId", -1L);
        } while ((i <= 0) || (l1 <= 0L) || (l2 <= 0L) || (k <= 0) || (l4 <= 0L) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null));
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(i, l1, l2, j, k, l3, l4);
        return;
        if (!paramIntent.getAction().equals("tencent.video.q2v.ACTION_RECV_C2B_PUSH_MSG")) {
          break;
        }
        paramContext = paramIntent.getStringExtra("uin");
      } while ((paramContext == null) || (!paramContext.equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c)));
      paramIntent = paramIntent.getStringExtra("context");
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().l = paramIntent;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().t = true;
      this.a.a(new Object[] { Integer.valueOf(309), paramContext, paramIntent });
      return;
    } while ((!paramIntent.getAction().equals("tencent.video.q2v.pstnCardInfoChanged")) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) || (paramIntent.getParcelableExtra("pstnCardInfo") == null) || (((PstnCardInfo)paramIntent.getParcelableExtra("pstnCardInfo")).pstn_multi_call_time <= 0));
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().v = 3;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */