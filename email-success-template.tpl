<STYLE>
    BODY, TABLE, TD, TH, P {
    font-family:Verdana,Helvetica,sans serif;
    font-size:11px;
    color:black;
    }
    h1 { color:black; }
    h2 { color:black; }
    h3 { color:black; }
    TD.bg1 { color:white; background-color:#595959; font-size:120% }
    TD.bg2 { color:white; background-color:#4040FF; font-size:110% }
    TD.bg3 { color:white; background-color:#8080FF; }
    TD.test_passed { color:#ccc; }
    TD.test_failed { color:red; }
    TD.console { font-family:Courier New, Lucida Console; }
</STYLE>
<BODY>
    <TABLE>

        <TR>
            <TD align="left">
            <IMG SRC="http://dev.cloudscripts.co.in:8080/static/eb749496/images/headshot.png"/>
            </TD>
            <TD valign="center"><B style="font-size: 200%;">School Backend Build Results</B></TD>
        </TR>
        <TR>
            <TD>URL</TD>
            <TD><A href="${BUILD_URL}">${JOB_NAME}</A></TD>
        </TR>
        <TR>
            <TD>JOB NAME:</TD>
            <TD>${JOB_NAME}</TD>
        </TR>
        <TR>
            <TD>VERSION:</TD>
            <TD>${VERSION}</TD>
        </TR>
        <TR>
            <TD>BUILD STATUS:</TD>
            <TD>SUCCESS!</TD>
        </TR>
        <TR>
            <TD>BUILD-NUMBER:</TD>
            <TD>${BUILD_DISPLAY_NAME}</TD>
        </TR>
        <TR>
            <TD>DATE/TIME:</TD>
            <TD>${BUILD_TIMESTAMP}</TD>
        </TR>
        <TR>
            <TD>TRIGGER:</TD>
            <TD>${BUILD_CAUSE}</TD>
        </TR>
    </TABLE>
    <BR/>

    <!-- CHANGE SET -->
     <TABLE width="100%">
        <TR>
            <TD class="bg1" colspan="2"><B>CHANGES</B></TD>
        </TR>
        <TR>
            <TD colspan="2">
                  <br/>
                 <div style="padding-left: 30px; padding-bottom: 15px;">
${CHANGES, showPaths=true, format="<div><b>%a</b>: %r %p </div><div style=\"padding-left:30px;\"> &#8212; &#8220;<em>%m</em>&#8221;</div>", pathFormat="</div><div style=\"padding-left:30px;\">%p"}
</div>
            </TD>
        </TR>
    </TABLE>  <BR/>

    <!-- ARTIFACTS -->
    <TABLE width="100%">
        <TR>
            <TD class="bg1"><B>BUILD ARTIFACTS</B></TD>
        </TR>
        <TR>
            <TD>
<br/>
<span>LINK TO ARTIFACTS HERE</span><br/>
<span>LINK TO ARTIFACTS HERE</span><br>
            </TD>
        </TR>
    </TABLE>
    <BR/>

    <!-- JUnit TEMPLATE -->
    <!-- ARTIFACTS -->
    <TABLE width="100%">
        <TR>
            <TD class="bg1"><B>UNIT TEST RESULTS</B></TD>
        </TR>
        </TR>
    </TABLE>
    <BR/>

<TABLE BORDER=0 CELLSPACING=2 CELLPADDING=2 Width="100%">
<TR><TD BGCOLOR="#0099CC" width="50%" height="30px"><FONT COLOR=White FACE="Geneva, Arial" SIZE=2>  Total</font></td><TD BGCOLOR="#FFFFFF"><FONT COLOR=#0099CC FACE="Geneva, Arial" SIZE=2>${TEST_COUNTS,var="total"}</font></td></TR>
</TABLE>

<TABLE BORDER=0 CELLSPACING=2 CELLPADDING=2 Width="100%">
<TR><TD BGCOLOR="#04B431" width="50%"><FONT COLOR=white FACE="Geneva, Arial" SIZE=2>  Pass</font></td><TD BGCOLOR="#FFFFFF"><FONT COLOR=#04B431 FACE="Geneva, Arial" SIZE=2>${TEST_COUNTS,var="pass"}</font></td></TR>
</TABLE>

<TABLE BORDER=0 CELLSPACING=2 CELLPADDING=2 Width="100%">
<TR><TD BGCOLOR="#DF3A01" width="50%"><FONT COLOR=white FACE="Geneva, Arial" SIZE=2>  Fail</font></td><TD BGCOLOR="#FFFFFF"><FONT COLOR=#DF3A01 FACE="Geneva, Arial" SIZE=2>${TEST_COUNTS,var="fail"}</font></td></TR>
</TABLE>

<TABLE BORDER=0 CELLSPACING=2 CELLPADDING=2 Width="100%">
<TR><TD BGCOLOR="#e6e600" width="50%"><FONT COLOR=white FACE="Geneva, Arial" SIZE=2>  Skip</font></td><TD BGCOLOR="#FFFFFF"><FONT COLOR=#A4A4A4 FACE="Geneva, Arial" SIZE=2>${TEST_COUNTS,var="skip"}</font></td></TR>
</TABLE>
<br/>

<TABLE BORDER=0 CELLSPACING=2 CELLPADDING=2 Width="100%">
<TR  BGCOLOR="#989898" width="100%"><td><FONT COLOR=White FACE="Geneva, Arial" SIZE=2>Unit Test  Failure Analysis</font></td></TR>
<TR  BGCOLOR="#f5f5f0" width="100%"><td><FONT COLOR=White FACE="Courier New, Lucida Console" SIZE=2>${FAILED_TESTS, showStack=false}</font></td></TR>
</TABLE>

<br/>
<TABLE BORDER=0 CELLSPACING=2 CELLPADDING=2 Width="100%">
<TR  BGCOLOR="#989898" width="70%"><td><FONT COLOR=White FACE="Geneva, Arial" SIZE=2>View Unit Test Report</font></td></TR>
<TR  width="70%"><td><FONT FACE="Geneva, Arial" SIZE=2><a href="${JOB_URL}lastBuild/testReport/">Click here to view</a></font></td></TR>
</TABLE>
<br/>
<TABLE BORDER=0 CELLSPACING=2 CELLPADDING=2 Width="100%">
<TR  BGCOLOR="#989898" width="100%"><td><FONT COLOR=White FACE="Geneva, Arial" SIZE=2>Unit Test Trend Graph</font></td></TR>
<TR width="70%"><td><img lazymap="${JOB_URL}test/trendMap" src="${JOB_URL}test/trend" alt="Trend Graph - Enable Email Images To View" usemap="${JOB_URL}test/trendMap#map0">
</TR>
</TABLE>

    <BR/>

    <!-- CONSOLE OUTPUT -->
    <TABLE width="100%" cellpadding="0" cellspacing="0">
        <TR>
            <TD class="bg1"><B>CONSOLE OUTPUT</B></TD>
        </TR>
        <TR>
            <TD class="console" width="80%">
                <br/>
${BUILD_LOG_REGEX, regex="^.*", linesAfter=1, substText="<br>$0"}
            </TD>
        </TR>
    </TABLE>
    <BR/>
</BODY>