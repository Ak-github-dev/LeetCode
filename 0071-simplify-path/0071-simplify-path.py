"""
Step-by-Step Algorithm:

Split the Path:

Split the path using slashes (/) to get individual components. This will help in isolating directories, current directory (.), parent directory (..), and potentially invalid entries like multiple consecutive dots.

Use a Stack for Directory Management:

Iterate through each component obtained after splitting.
For each component, decide the action based on its value:
Empty String or .: These indicate either an empty component due to consecutive slashes or the current directory. In both cases, do nothing.
..: This indicates moving up one directory level. Pop from the stack if it's not empty (i.e., if not at the root).
Directory Names (..., a, etc.): Push the valid directory name onto the stack.

Build the Simplified Path:

After processing all components, construct the simplified path by joining all elements in the stack, prepended by a slash.
If the stack is empty, return the root path /.
"""
class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        components = path.split("/")
        stack = []
        
        for component in components:
            if component == "..":
                if stack:
                    stack.pop()
            elif component and component != ".":
                stack.append(component)
        
        # Join all components in the stack with a slash
        simplified_path = "/" + "/".join(stack)
        return simplified_path