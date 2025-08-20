from flask import Flask, request, jsonify
from clip_utils import compute_similarity

app = Flask(__name__)

@app.route('/clip/similarity', methods=['POST'])
def get_similarity():
    data = request.get_json()
    image_path = data['image_path']
    text = data['description']
    score = compute_similarity(image_path, text)
    return jsonify({'similarity': score})

# ✅ ADD THIS:
if __name__ == '__main__':
    app.run(debug=True)
