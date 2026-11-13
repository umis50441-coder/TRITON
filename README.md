# TRITON – Smart Ride Assistant (starter project)

**Important:** This is a working *starter/demo codebase*, NOT the promised production-ready all-feature app. It has an Android demo UI, a static responsive admin website demo, and a read-only Node.js demo API. There is NO live OTP, payment collection, subscription activation, real driver account database, GPS, ride monitoring, auto accept/reject, or mobile admin login. Do not charge users for this demo.

## Android APK using only your phone
1. On your phone, create a GitHub repository and upload **all files and folders**, including `.github/workflows/android-apk.yml`, preserving paths. (The GitHub website may make multi-file uploads inconvenient; extracting this ZIP and using a Git client can help.)
2. Ensure the default branch is `main`. Open the repository's **Actions** tab, select **Build Android debug APK**, then **Run workflow**.
3. Wait for the build to complete. Open the run's **Artifacts**, download `triton-debug-apk`, extract it, and install the debug APK for testing.
4. If the build fails, check the job logs. This starter workflow uses Gradle installed on GitHub's runner and Android SDK 35; update versions if runner images change.

## Web admin demo
Open `admin/index.html` in your phone browser. This is static and does not connect to a user database.

## Backend demo
With Node.js 18+, run `cd backend && npm start`; endpoints: `/api/status` and `/api/plans`. No authentication or write endpoints are provided.

## Production work required
- Implement phone OTP with Firebase Auth (server-side ID-token verification), user registration, role-based admin authorization and secure database.
- Integrate a payment gateway using server-side order creation, signature/webhook verification, idempotency and subscription expiry; comply with app-store payment rules.
- Implement driver preferences, notifications and voice alerts with user consent and platform policies.
- Check official provider permissions/API support before building any automatic ride acceptance/rejection. This project does NOT bypass other apps' restrictions.
- Implement proper privacy policy, data deletion, logging, security testing, localization, release signing, and device testing.

## ಕನ್ನಡ ಸೂಚನೆ
ಈ ZIP ಒಂದು **ಆರಂಭಿಕ ಡೆಮೊ ಪ್ರಾಜೆಕ್ಟ್**. ನಿಜವಾದ OTP, UPI ಪಾವತಿ, Ride Auto Accept/Reject ಇನ್ನೂ ಇಲ್ಲ. ಮೊಬೈಲ್‌ನಲ್ಲಿ GitHub repository ಗೆ ZIP ಒಳಗಿನ ಫೈಲ್‌ಗಳನ್ನು upload ಮಾಡಿ, Actions → Build Android debug APK → Run workflow ಒತ್ತಿರಿ. Build ಮುಗಿದ ನಂತರ Artifacts ನಿಂದ APK ಪಡೆದುಕೊಳ್ಳಿ.
