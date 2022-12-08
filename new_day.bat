copy src\main\kotlin\aoc\year2022\Day00.kt src\main\kotlin\aoc\year2022\Day%1.kt
copy src\test\kotlin\aoc\year2022\TestDay00.kt src\test\kotlin\aoc\year2022\TestDay%1.kt
copy src\test\resources\year2022\Day00.txt src\test\resources\year2022\Day%1.txt
copy src\test\resources\year2022\Day00_test.txt src\test\resources\year2022\Day%1_test.txt

powershell -Command "(Get-Content src\main\kotlin\aoc\year2022\Day06.kt).replace('00', '06') | Out-File -encoding utf8 src\main\kotlin\aoc\year2022\Day06.kt"
powershell -Command "(Get-Content src\test\kotlin\aoc\year2022\TestDay%1.kt).replace('00', '%1') | Out-File -encoding utf8 src\test\kotlin\aoc\year2022\TestDay%1.kt"
