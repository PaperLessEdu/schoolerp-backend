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
            <TD>${BUILD_STATUS}</TD>
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