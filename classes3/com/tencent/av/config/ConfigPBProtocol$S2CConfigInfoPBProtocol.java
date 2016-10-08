package com.tencent.av.config;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import ghc;
import java.util.List;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AndroidCameraInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AudioSwitchPointInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdToClientConfigInfoRspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileQQPttInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.PutinfoHead;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.RspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.SharpTraeInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.TransBuffer;

public class ConfigPBProtocol$S2CConfigInfoPBProtocol
{
  private ConfigPBProtocol.ConfigSysInfoNew jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew;
  private hd_video_putinfo.RspBody jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody;
  
  public ConfigPBProtocol$S2CConfigInfoPBProtocol(ConfigPBProtocol paramConfigPBProtocol)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew = new ConfigPBProtocol.ConfigSysInfoNew(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol);
    this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody = new hd_video_putinfo.RspBody();
  }
  
  private int a()
  {
    int k = 0;
    int i;
    if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.has()) {
      i = -1;
    }
    Object localObject1;
    boolean bool;
    int j;
    label1194:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            localObject1 = (hd_video_putinfo.CmdToClientConfigInfoRspBody)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.get();
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.has())
            {
              i = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.get();
              localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew;
              if (i != 0) {
                break;
              }
              bool = false;
              ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_Boolean = bool;
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.has()) {
              ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.get().toStringUtf8();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.has())
            {
              localObject2 = (hd_video_putinfo.AndroidCameraInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.a = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param1.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.b = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param2.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.c = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param3.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.d = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param4.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.e = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param5.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.f = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param6.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.g = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param7.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.h = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param8.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.i = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param9.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.j = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param10.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.k = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param11.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggx.l = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param12.get());
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.has())
            {
              localObject2 = (hd_video_putinfo.SharpTraeInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.jdField_a_of_type_Int = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_source.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.jdField_b_of_type_Int = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_interface.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.c = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_stream_type.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.d = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_volume.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.e = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_mode.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.f = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_arm_flag.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.g = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_cpu_hertz.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Gha.h = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_audio_set.get();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.has())
            {
              long l = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.a = ((byte)(int)(l & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.b = ((byte)(int)(l >> 1 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.c = ((byte)(int)(l >> 2 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.d = ((byte)(int)(l >> 3 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.e = ((byte)(int)(l >> 4 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.f = ((byte)(int)(l >> 5 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.g = ((byte)(int)(l >> 6 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.h = ((byte)(int)(l >> 7 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ghb.i = ((byte)(int)(l >> 13 & 1L));
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.has())
            {
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.jdField_a_of_type_Boolean = true;
              localObject2 = (hd_video_putinfo.MobileQQPttInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.jdField_a_of_type_Int = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param1.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.jdField_b_of_type_Int = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param2.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.c = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param3.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.d = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param4.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.e = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param5.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.f = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param6.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.g = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param7.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.h = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param8.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.i = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param9.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.j = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param10.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.k = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param11.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.l = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param12.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.m = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param13.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.n = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param14.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggz.o = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param15.get();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.has())
            {
              localObject2 = (hd_video_putinfo.AudioSwitchPointInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.jdField_a_of_type_Int = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_shake.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.jdField_b_of_type_Int = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_time_delay.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.c = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.d = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss_rate.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.jdField_a_of_type_JavaLangString = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_wifi_words.get().toStringUtf8();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.e = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_shake.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.f = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_time_delay.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.g = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.h = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss_rate.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Ggy.jdField_b_of_type_JavaLangString = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_nowifi_words.get().toStringUtf8();
            }
            i = k;
          } while (!((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.has());
          localObject1 = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.get();
          i = k;
        } while (localObject1 == null);
        i = k;
      } while (((List)localObject1).size() <= 0);
      j = 0;
      i = k;
    } while (j >= ((List)localObject1).size());
    Object localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew;
    localObject2.getClass();
    localObject2 = new ghc((ConfigPBProtocol.ConfigSysInfoNew)localObject2);
    ((ghc)localObject2).jdField_a_of_type_Int = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).uint32_type.get();
    ((ghc)localObject2).jdField_a_of_type_JavaLangString = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).bytes_content.get().toStringUtf8();
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_JavaUtilList.add(localObject2);
    if (((ghc)localObject2).jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_JavaLangString = ((ghc)localObject2).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      j += 1;
      break label1194;
      bool = true;
      break;
      if (((ghc)localObject2).jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_b_of_type_JavaLangString = ((ghc)localObject2).jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    try
    {
      this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.mergeFrom(paramArrayOfByte);
      if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.has()) {
        return -1;
      }
      paramArrayOfByte = (hd_video_putinfo.PutinfoHead)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.get();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_error_no.has()) && (paramArrayOfByte.uint32_error_no.get() == 0) && (paramArrayOfByte.enum_body_type.has()) && (paramArrayOfByte.enum_body_type.get() == 2))
      {
        if (paramArrayOfByte.bytes_config_ver.has()) {
          ConfigPBProtocol.jdField_a_of_type_JavaLangString = paramArrayOfByte.bytes_config_ver.get().toStringUtf8();
        }
        int i = a();
        return i;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public ConfigPBProtocol.ConfigSysInfoNew a()
  {
    return this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\config\ConfigPBProtocol$S2CConfigInfoPBProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */