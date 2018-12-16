param($FileName)
"FileName=$FileName"

$num = 0
IF ($FileName){
    $filename = $FileName   
    $content = Get-Content .\run_java.ps1
    $content = $content -replace "filename = `".*`"", ("filename = `"$FileName`"")
    $content > .\run_java.ps1
} ELSE {
    $filename = "demo34"
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

    javac -cp . -d . -encoding UTF-8 ($filename + ".java")


    java $filename
    Get-ChildItem * -Include *.class -Recurse | Remove-Item
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
