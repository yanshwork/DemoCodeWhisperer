# Running a command without validating input
import subprocess
cmd = input('Enter a command to run.');
subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE)