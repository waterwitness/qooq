package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.config.Command;
import com.tencent.mobileqq.config.CommandListener;
import com.tencent.mobileqq.config.ConfigDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ADMsg
  implements CommandListener
{
  private static Command jdField_a_of_type_ComTencentMobileqqConfigCommand;
  private static Command b;
  private static Command c;
  private static Command d;
  private ADMsg.TextBox jdField_a_of_type_ComTencentMobileqqConfigStructADMsg$TextBox;
  public String a;
  public String b;
  public String c;
  public String d;
  private Command e;
  public String e;
  public String f;
  public String g;
  
  public ADMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.f = "";
    this.g = "";
  }
  
  public void a()
  {
    if (this.jdField_e_of_type_JavaLangString.equals("LOCAL")) {
      if (!this.f.equals("1")) {}
    }
    label24:
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
              break label24;
              break label24;
              break label24;
              do
              {
                return;
              } while ((this.f.equals("2")) || (this.f.equals("4")) || (this.f.equals("5")) || (this.f.equals("6")) || (!this.f.equals("7")));
              return;
            } while ((this.jdField_e_of_type_JavaLangString.equals("WAP")) || (this.jdField_e_of_type_JavaLangString.equals("TMTWAP")) || (this.jdField_e_of_type_JavaLangString.equals("WAPI")) || (this.jdField_e_of_type_JavaLangString.equals("TMTWAPI")) || (this.jdField_e_of_type_JavaLangString.equals("VOICECALL")));
            if (!this.jdField_e_of_type_JavaLangString.equals("QQMSG")) {
              break;
            }
          } while (!this.jdField_c_of_type_JavaLangString.equals("AUTO"));
          return;
        } while ((this.jdField_e_of_type_JavaLangString.equals("AUTOQQMSG")) || (this.jdField_e_of_type_JavaLangString.equals("HTTP")) || (this.jdField_e_of_type_JavaLangString.equals("AUTOSMS")));
        if (!this.jdField_e_of_type_JavaLangString.equals("USERSMS")) {
          break;
        }
      } while (!this.jdField_c_of_type_JavaLangString.equals("AUTO"));
      return;
    } while (!this.jdField_e_of_type_JavaLangString.equals("RESET"));
  }
  
  public void a(Command paramCommand, ConfigDialog paramConfigDialog)
  {
    if ((!paramCommand.equals(jdField_c_of_type_ComTencentMobileqqConfigCommand)) || ((!paramCommand.equals(jdField_d_of_type_ComTencentMobileqqConfigCommand)) || (paramCommand.equals(this.jdField_e_of_type_ComTencentMobileqqConfigCommand)))) {
      a();
    }
    if ((!paramCommand.equals(jdField_a_of_type_ComTencentMobileqqConfigCommand)) || (this.jdField_e_of_type_JavaLangString.equals("USERSMS"))) {}
    for (;;)
    {
      if (paramCommand.equals(jdField_b_of_type_ComTencentMobileqqConfigCommand)) {}
      return;
      if (!this.jdField_e_of_type_JavaLangString.equals("QQMSG")) {}
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new Command[1];
    if (paramBoolean)
    {
      paramString1[0] = jdField_d_of_type_ComTencentMobileqqConfigCommand;
      return;
    }
    paramString1[0] = jdField_c_of_type_ComTencentMobileqqConfigCommand;
  }
  
  public void a(boolean paramBoolean)
  {
    Command[] arrayOfCommand = new Command[2];
    if ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_e_of_type_JavaLangString.equals("")))
    {
      if (this.jdField_e_of_type_ComTencentMobileqqConfigCommand == null) {
        this.jdField_e_of_type_ComTencentMobileqqConfigCommand = new Command(this.jdField_d_of_type_JavaLangString, 1, 1);
      }
      arrayOfCommand[0] = this.jdField_e_of_type_ComTencentMobileqqConfigCommand;
    }
    if (paramBoolean)
    {
      arrayOfCommand[1] = jdField_d_of_type_ComTencentMobileqqConfigCommand;
      return;
    }
    arrayOfCommand[1] = jdField_c_of_type_ComTencentMobileqqConfigCommand;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\struct\ADMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */