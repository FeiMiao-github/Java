param($FileName)
"FileName=$FileName"

$num = 0
IF ($FileName){
    $filename = $FileName   
    $content = Get-Content .\run_java.ps1
    $content = $content -replace "filename = `".*`"", ("filename = `"$FileName`"")
    $content > .\run_java.ps1
} ELSE {
    $filename = "demo81"
}

$path = "F:\github\Java\javaDemo\"
do {
    F:
    cd $path
    cls
    

    #dir
    $s = "*" + "  文件名: " + "$filename" + "  *"
    echo "********************"
    echo $s
    echo "********************"
    echo ""
    echo ""
    # $test = ($filename + "`\Main")
    # echo $test
    


    IF((Test-Path ($filename)) -and (((Get-Item ($filename)).GetType()).name -eq 'DirectoryInfo')) {
        Get-ChildItem ($filename) | ForEach-Object -Process{
            javac -cp . -d ($filename) -encoding UTF-8 ($filename + "`\*.java")
        }
        cd ($filename)
        java Main
    } ELSEIF(Test-Path ($filename + ".java")) {
        javac -cp . -d . -encoding UTF-8 ($filename + ".java")
        java $filename
    }
    # Read-Host
    Get-ChildItem * -Include *.class -Recurse | Remove-Item
    Get-ChildItem * -Include *.txt -Recurse | Remove-Item
    $num = $num + 1

    $s = "*   " + "运行次数: " + "$num" + "    *"
    echo ""
    echo ""
    echo "********************"
    echo $s
    echo "********************"

    $input = Read-Host
} while(($input -ne "q") -and $input -ne "Q")

# cd C:\Users\JZ\Desktop\script_shell
cd $path
