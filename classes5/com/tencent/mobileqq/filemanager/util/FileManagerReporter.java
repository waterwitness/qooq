package com.tencent.mobileqq.filemanager.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class FileManagerReporter
{
  private static final String a = "FileManagerReporter<FileAssistant>";
  
  public FileManagerReporter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.jdField_b_of_type_JavaLangString = paramString;
      localfileAssistantReportData.jdField_a_of_type_JavaLangString = paramString;
      if (localfileAssistantReportData.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", localfileAssistantReportData.jdField_a_of_type_JavaLangString, localfileAssistantReportData.jdField_b_of_type_JavaLangString, localfileAssistantReportData.jdField_a_of_type_Int, localfileAssistantReportData.jdField_b_of_type_Int, i, String.valueOf(localfileAssistantReportData.jdField_b_of_type_Long), localfileAssistantReportData.d, FileManagerReporter.fileAssistantReportData.a(localfileAssistantReportData), localfileAssistantReportData.c);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerReporter<FileAssistant>", 2, "report key:" + paramString);
        return;
      }
    }
  }
  
  public static void a(String paramString, FileManagerReporter.fileAssistantReportData paramfileAssistantReportData)
  {
    BaseApplicationImpl.getContext();
    paramString = BaseApplicationImpl.a().a();
    if ((paramString != null) && ((paramString instanceof QQAppInterface))) {}
    for (paramString = (QQAppInterface)paramString;; paramString = null)
    {
      if (paramfileAssistantReportData.jdField_a_of_type_Boolean) {}
      for (int i = 0;; i = 1)
      {
        ReportController.b(paramString, "CliOper", "", "", paramfileAssistantReportData.jdField_a_of_type_JavaLangString, paramfileAssistantReportData.jdField_b_of_type_JavaLangString, paramfileAssistantReportData.jdField_a_of_type_Int, paramfileAssistantReportData.jdField_b_of_type_Int, i, String.valueOf(paramfileAssistantReportData.jdField_b_of_type_Long), paramfileAssistantReportData.d, FileManagerReporter.fileAssistantReportData.a(paramfileAssistantReportData), paramfileAssistantReportData.c);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FileManagerReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */