/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      backgroundImage: {
        "custom-gradient": "linear-gradient(to right, #1a1a1a, #000000)",
        "custom-gradient-2": "linear-gradient(to left, #1a1a1a, #000000)",
        "card-gradient": "linear-gradient(to right, #f3f4f6, #ffffff)",
      },
      colors: {
        navbarColor: "#ffffff",
        btnColor: "#000000",
        linkColor: "#1a1a1a",
      },
      boxShadow: {
        custom: "0 0 15px rgba(0, 0, 0, 0.3)",
        right: "10px 0px 10px -5px rgba(0, 0, 0, 0.3)",
      },
      fontFamily: {
        roboto: ["Geist Mono", "monospace"],
        montserrat: ["Geist Mono", "monospace"],
        sans: ["Geist Mono", "monospace"],
      },
    },
  },

  variants: {
    extend: {
      backgroundImage: ["responsive"],
    },
  },

  plugins: [],
};