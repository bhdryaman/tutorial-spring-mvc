<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <body>
            	<div align="left">
                	<xsl:apply-templates />
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="jobs">
        <table border="1">
            <xsl:for-each select="job">
                <tr>
                    <td>
                        <xsl:value-of select="jid" />
                    </td>
                    <td>                       
                        <xsl:value-of select="position" />                       
                    </td>
                    <td>
                        <xsl:value-of select="type" />
                    </td>
                    <td>
                        <xsl:value-of select="location" />
                    </td>
                    <td>
                        <xsl:value-of select="company" />
                    </td>
                     
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>