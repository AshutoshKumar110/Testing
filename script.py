import xml.dom.minidom;from collections import Counter;import json;print(json.dumps({**dict(Counter(map(lambda x : str(x.firstChild.nodeValue).split(" ")[0],xml.dom.minidom.parse("dependency-check-report.xml").getElementsByTagName("severity")))),**{"AppName":"Hackathon"}}))