<%-- 
    Document   : Home
    Created on : Oct 9, 2023, 9:24:03 AM
    Author     : Mr.Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Fap!</h1>

    <td valign="top">
        <h4>Information Access(Tra cứu
            thông tin)</h4>
        <ul>

            <li><a
                    href="FrontOffice/SubjectFees.aspx">Tuition
                    fee per course</a>
                (Biểu học phí)</li>
            <li><a
                    href="Report/ScheduleOfWeek.aspx">Weekly
                    timetable</a> (Thời
                khóa biểu từng tuần)
            </li>
            <li><a
                    href="Report/ScheduleOfWeek.aspx">
                    Mark Report
                </a> (Báo cáo điểm)
            </li>
            <li><a
                    href="Schedule/FunixSchedule.aspx">Blended
                    Online Course (BLOC)
                    Schedules </a>(Lịch
                học các môn theo phương
                pháp BLOC trong kỳ)</li>
            <li><a href="Exam/ScheduleExams.aspx"
                   target="_blank">View
                    exam schedule
                </a>(Xem lịch thi)
                <img src="images/New_icons_10.gif"
                     id="ctl00_mainContent_imgIcon">
            </li>
            <span
                id="ctl00_mainContent_lnkhocphi"></span>
            <li><a href="http://flm.fpt.edu.vn"
                   id="ctl00_mainContent_lnkSyllanus"
                   target="_blank">View
                    Syllabuses</a>(Xem
                đề cương môn học)</li>
            <li><a href="https://fap.fpt.edu.vn/temp/Regulations/Huong_dan_KTXH_tren_EduNext_Sp23_Sinh_Vien.pdf"
                   target="_blank">EduNext
                    student
                    guideline</a><img
                    src="images/New_icons_10.gif"
                    id="ctl00_mainContent_img1">
            </li>
            <span
                id="ctl00_mainContent_lblhelp">
                <li><a href="Report/Help.aspx"
                       target="_blank">Help/Hỗ
                        trợ</a><img
                        runat="server"
                        id="img3"
                        visible="true"
                        src="images/New_icons_10.gif">
                </li>
            </span>
            <span
                id="ctl00_mainContent_lblOR">
                <li><a href="https://fap.fpt.edu.vn/temp/Regulations/Slide_OR_student.rar"
                       target="_blank">Tài
                        liệu hướng dẫn:
                        Định hướng cho
                        sinh
                        viên</a><img
                        runat="server"
                        id="img2"
                        src="images/New_icons_10.gif"
                        alt=""></li>
            </span>
        </ul>
    </td>

</body>
</html>
