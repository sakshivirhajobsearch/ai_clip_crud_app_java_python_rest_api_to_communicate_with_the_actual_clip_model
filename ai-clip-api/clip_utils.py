import torch
import clip
from PIL import Image
import os

device = "cuda" if torch.cuda.is_available() else "cpu"

# ✅ Load model and preprocess ONCE
model, preprocess = clip.load("ViT-B/32", device=device)

def compute_similarity(image_path, text):
    print(f"Looking for image at: {image_path}")
    print("Absolute path:", os.path.abspath(image_path))

    if not os.path.exists(image_path):
        return f"Error: Image not found at path '{image_path}'"

    image = preprocess(Image.open(image_path)).unsqueeze(0).to(device)
    text = clip.tokenize([text]).to(device)

    with torch.no_grad():
        image_features = model.encode_image(image)
        text_features = model.encode_text(text)

    similarity = torch.cosine_similarity(image_features, text_features).item()
    return similarity
